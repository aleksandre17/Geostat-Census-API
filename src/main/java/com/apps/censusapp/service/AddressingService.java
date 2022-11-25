package com.apps.censusapp.service;

import com.apps.censusapp.entity.Addressing;

import java.util.List;

public interface AddressingService {

    Addressing getAddressingByUuid(Addressing addressing);

    Integer updateAddressingStatus(List<String> uuids);
}
