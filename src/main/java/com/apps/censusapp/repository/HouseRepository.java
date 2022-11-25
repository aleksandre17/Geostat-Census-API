package com.apps.censusapp.repository;

import com.apps.censusapp.entity.Addressing;
import com.apps.censusapp.entity.House;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

    @Query(value = "SELECT * FROM houses where house_code = ?1", nativeQuery = true)
    House findByHouseCode(String houseCode);

//    @Query(value = "SELECT a.*, b.* from houses a inner join addressings b on a.house_code = b.house_id where left(house_code, len(house_code) - 4) = ?1 and (status in (5, 6) or exists (select 1 from addressings where house_id = a.house_code and addressing_status_id = 2) ) ", nativeQuery = true)
    @Query(value = "SELECT a.*, b.* from houses a left join addressings b on a.house_code = b.house_id where left(house_code, len(house_code) - 4) = ?1 and (status in (3, 5, 6)) ", nativeQuery = true)
    List<House> selectDeletedHouses(String districtId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE houses SET status = 8 where house_code in (?1)", nativeQuery = true)
    Integer updateHousesStatus(List<String> uuids);

}
