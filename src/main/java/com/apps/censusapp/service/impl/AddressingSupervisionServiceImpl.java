package com.apps.censusapp.service.impl;

import com.apps.censusapp.entity.SupervisionEntity;
import com.apps.censusapp.repository.AddressingSupervisionRepository;
import com.apps.censusapp.service.AddressingSupervisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressingSupervisionServiceImpl implements AddressingSupervisionService {

    @Autowired
    AddressingSupervisionRepository addressingSupervisionRepository;

    @Override
    public SupervisionEntity getSupervisionByAddressingUid(SupervisionEntity supervisionEntity) {
        return addressingSupervisionRepository.findByAddressingUuid(supervisionEntity.getAddressing_uuid());
    }
}
