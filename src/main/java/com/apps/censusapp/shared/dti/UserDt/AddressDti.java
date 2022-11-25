package com.apps.censusapp.shared.dti.UserDt;

public class AddressDti {

    private long id;
    private String address;
    private String addressAlter;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressAlter() {
        return addressAlter;
    }

    public void setAddressAlter(String addressAlter) {
        this.addressAlter = addressAlter;
    }
}
