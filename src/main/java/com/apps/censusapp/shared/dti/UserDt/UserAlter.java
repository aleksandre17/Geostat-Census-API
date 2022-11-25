package com.apps.censusapp.shared.dti.UserDt;

import com.apps.censusapp.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


public class UserAlter {

    private Integer id;

    private String firstName;

    private String LastName;

    private String personId;

    private Date inactive;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getInactive() {
        return inactive;
    }

    public void setInactive(Date inactive) {
        this.inactive = inactive;
    }

}
