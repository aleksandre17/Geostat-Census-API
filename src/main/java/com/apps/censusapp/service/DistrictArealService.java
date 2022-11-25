package com.apps.censusapp.service;

import com.apps.censusapp.entity.DistrictArealEntity;

public interface DistrictArealService {

    DistrictArealEntity getDistrictArealByDistrCode (DistrictArealEntity districtAreal);

    DistrictArealEntity insertOrCreate(DistrictArealEntity districtArealEntity);
}
