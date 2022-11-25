package com.apps.censusapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "userLocations")
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, name = "address_alter")
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
