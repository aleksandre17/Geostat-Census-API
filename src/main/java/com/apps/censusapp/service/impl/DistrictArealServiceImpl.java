package com.apps.censusapp.service.impl;

import com.apps.censusapp.entity.DistrictArealEntity;
import com.apps.censusapp.repository.DistrictArealRepository;
import com.apps.censusapp.service.DistrictArealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DistrictArealServiceImpl implements DistrictArealService {

    @Autowired
    DistrictArealRepository districtArealRepository;

    @Override
    public DistrictArealEntity getDistrictArealByDistrCode(DistrictArealEntity districtAreal) {
        return districtArealRepository.findByDistrictCode(districtAreal.getDistr_code());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public DistrictArealEntity insertOrCreate(DistrictArealEntity districtArealEntity) {
        return districtArealRepository.save(districtArealEntity);
    }
}
