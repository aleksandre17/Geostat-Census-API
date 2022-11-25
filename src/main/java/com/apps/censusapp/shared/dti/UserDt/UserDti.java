package com.apps.censusapp.shared.dti.UserDt;

import java.io.Serializable;
import java.util.List;

public class UserDti implements Serializable {

    private Long id;
    private UserDti parent;
    private String userName;
    private String password;
    private String encryptedPassword;
    private UserAlter user;
    private List<AddressDti> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }


    public List<AddressDti> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDti> addresses) {
        this.addresses = addresses;
    }


    public UserDti getParent() {
        return parent;
    }

    public void setParent(UserDti parent) {
        this.parent = parent;
    }

    public UserAlter getUser() {
        return user;
    }

    public void setUser(UserAlter user) {
        this.user = user;
    }
}
