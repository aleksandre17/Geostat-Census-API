package com.apps.censusapp.service.impl;

import com.apps.censusapp.repository.AddressingRepository;
import com.apps.censusapp.entity.Addressing;
import com.apps.censusapp.service.AddressingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressingServiceImpl implements AddressingService {

    @Autowired
    AddressingRepository addressingRepository;

    @Override
    public Addressing getAddressingByUuid(Addressing addressing) {
        return addressingRepository.findByUuid(addressing.getUuid());
    }

    @Override
    public Integer updateAddressingStatus(List<String> uuids) {
        return addressingRepository.updateAddressingStatus(uuids);
    }
}
