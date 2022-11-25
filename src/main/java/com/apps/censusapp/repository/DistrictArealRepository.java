package com.apps.censusapp.repository;

import com.apps.censusapp.entity.DistrictArealEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictArealRepository extends CrudRepository<DistrictArealEntity, Long> {

    @Query(value = "SELECT * FROM district_areal where distr_code = ?1", nativeQuery = true)
    DistrictArealEntity findByDistrictCode(String districtCode);
}
