package com.apps.censusapp.ui.model.request.wrapper;

import com.apps.censusapp.entity.Holder;
import com.apps.censusapp.entity.SupervisionEntity;
import com.apps.censusapp.ui.model.request.AddressingRequest;
import com.apps.censusapp.ui.model.request.HolderRequest;
import com.apps.censusapp.ui.model.request.SupervisionEntityRequest;

import java.util.List;

public class AddressingWithHolders {

    public AddressingRequest addressing;

    public List<HolderRequest> holder;

    public SupervisionEntityRequest supervisionEntity;

    public AddressingRequest getAddressing() {
        return addressing;
    }

    public List<HolderRequest> getHolder() {
        return holder;
    }

    public SupervisionEntityRequest getSupervisionEntity() {
        return supervisionEntity;
    }
}