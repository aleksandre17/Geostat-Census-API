package com.apps.censusapp.service.impl;

import com.apps.censusapp.repository.HouseRepository;
import com.apps.censusapp.entity.House;
import com.apps.censusapp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseRepository houseRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public List<House> createAddressing(List<House> houses) {
        return (List<House>) houseRepository.saveAll(houses);
    }

    @Override
    public House getHouseByHouseCode(House house) {
        House addressing1 = houseRepository.findByHouseCode(house.getHouse_code());

        return addressing1;
    }

    @Override
    public List<House> getResponseHouses(String districtArea) {
        return houseRepository.selectDeletedHouses(districtArea);
    }

    @Override
    public Integer updateHouseStatus(List<String> uuids) {
        return houseRepository.updateHousesStatus(uuids);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
