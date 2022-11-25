package com.apps.censusapp.service;

import com.apps.censusapp.entity.Addressing;
import com.apps.censusapp.entity.House;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface HouseService extends UserDetailsService {
    List<House> createAddressing(List<House> houses);

    House getHouseByHouseCode(House house);

    List<House> getResponseHouses(String districtArea);

    Integer updateHouseStatus(List<String> uuids);

}
