package com.apps.censusapp.ui.controller;

import com.apps.censusapp.entity.*;
import com.apps.censusapp.service.AddressingService;
import com.apps.censusapp.service.AddressingSupervisionService;
import com.apps.censusapp.service.DistrictArealService;
import com.apps.censusapp.service.HouseService;
import com.apps.censusapp.ui.model.request.HolderRequest;
import com.apps.censusapp.ui.model.request.wrapper.AddressingWithHolders;
import com.apps.censusapp.ui.model.request.wrapper.DistrictArealRequest;
import com.apps.censusapp.ui.model.request.wrapper.HouseRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RestController
@RequestMapping("addressing")
public class AddressingController {

    @Autowired
    DistrictArealService districtArealService;

    @Autowired
    HouseService houseService;

    @Autowired
    AddressingService addressingService;

    @Autowired
    AddressingSupervisionService addressingSupervisionService;

    @PostMapping
    public ResponseEntity<List<House>> insertAddressing (@RequestBody DistrictArealRequest districtArealRequest) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("MAPPER " + mapper.writeValueAsString(districtArealRequest));

        DistrictArealEntity districtArealEntity = new DistrictArealEntity();
        BeanUtils.copyProperties(districtArealRequest, districtArealEntity);

        com.apps.censusapp.entity.DistrictArealEntity findOrNew = districtArealService.getDistrictArealByDistrCode(districtArealEntity);
        if (findOrNew != null) districtArealEntity.setId(findOrNew.getId());

        districtArealRequest.getHouses().forEach(new Consumer<HouseRequest>() {
            @Override
            public void accept(HouseRequest houseRequest) {

                com.apps.censusapp.entity.House house1 = new com.apps.censusapp.entity.House();
                BeanUtils.copyProperties(houseRequest, house1);

                com.apps.censusapp.entity.House uploaded = houseService.getHouseByHouseCode(house1);
                if (uploaded != null) {
                    house1.setId(uploaded.getId());
                    if (uploaded.getStatus().equals(3) || uploaded.getStatus().equals(5)) {
                        house1.setStatus(uploaded.getStatus());
                    } else if (uploaded.getStatus().equals(6) && house1.getStatus().equals(4)) {
                        house1.setStatus(uploaded.getStatus());
                    } else if (uploaded.getStatus().equals(8) && !house1.getStatus().equals(2)) {
                        house1.setStatus(uploaded.getStatus());
                    }
                }

                houseRequest.getAddressing().forEach(new Consumer<AddressingWithHolders>() {
                    @Override
                    public void accept(AddressingWithHolders addressingWithHolders) {

                        if (addressingWithHolders.addressing.getStatus().equals(0)) addressingWithHolders.addressing.setStatus(1);

                        Addressing addressing1 = new Addressing();
                        BeanUtils.copyProperties(addressingWithHolders.addressing, addressing1);

                        Addressing findByUuid = addressingService.getAddressingByUuid(addressing1);

                        try {
                            System.out.println("findByUuid" + new ObjectMapper().writeValueAsString(findByUuid));
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }

                        if (findByUuid != null) {
                            addressing1.setId(findByUuid.getId());
                            addressing1.setRollbackComment(findByUuid.getRollbackComment());
                            if (findByUuid.getStatus().equals(4)) {
                                /// გასავლელი
                                BeanUtils.copyProperties(findByUuid, addressing1);
                            } else if (findByUuid.getStatus().equals(2)) {
                                addressing1.setStatus(2);
                            } else if (!addressing1.getStatus().equals(1)) {
                                addressing1.setStatus(3);
                            }

                        } else {
                            addressing1.setId(null);
                        }

                        addressingWithHolders.holder.forEach(new Consumer<HolderRequest>() {
                            @Override
                            public void accept(HolderRequest holder) {
                                Holder holder1 = new Holder();
                                holder.setId(null);

                                BeanUtils.copyProperties(holder, holder1);
                                addressing1.addHolder(holder1);
                            }
                        });

                        if (addressingWithHolders.supervisionEntity != null) {

                            SupervisionEntity supervisionEntity = new SupervisionEntity();
                            BeanUtils.copyProperties(addressingWithHolders.supervisionEntity, supervisionEntity);

                            addressing1.setSupervision(supervisionEntity);

                            SupervisionEntity find = addressingSupervisionService.getSupervisionByAddressingUid(supervisionEntity);

                            if (find != null) {
                                supervisionEntity.setId(find.getId());
                            } else {
                                supervisionEntity.setId(null);
                            }
                        }

                        house1.addAddresses(addressing1);

                    }
                });

                districtArealEntity.addHouse(house1);
            }
        });

        if (districtArealService.insertOrCreate(districtArealEntity) != null) {

            ObjectMapper mapper1 = new ObjectMapper();

            List<House> houses = houseService.getResponseHouses(districtArealEntity.getDistr_code());
            JavaType javaType = mapper1.getTypeFactory().constructCollectionType(List.class, House.class);
            List<House> tmpHouse = mapper1.readValue(mapper1.writeValueAsString(houses), javaType);

            houses.forEach(new Consumer<House>() {
                @Override
                public void accept(House house) {
                    List<String> addressings = house.getAddresses().stream().filter(addressing -> addressing.getStatus().equals(2)).peek(addressing -> addressing.setStatus(3)).map(Addressing::getUuid).collect(Collectors.toList());
                    try {
                        System.out.println("TEST " + new ObjectMapper().writeValueAsString(addressings));
                        addressingService.updateAddressingStatus(addressings);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            List<String> updatedHouses = houses.stream().filter(house -> house.getStatus().equals(3)).map(House::getHouse_code).collect(Collectors.toList());

            houseService.updateHouseStatus(updatedHouses);

            try {
                System.out.println(mapper.writeValueAsString(houses));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return new ResponseEntity<>(tmpHouse, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
