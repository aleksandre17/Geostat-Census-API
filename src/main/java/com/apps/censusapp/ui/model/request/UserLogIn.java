package com.apps.censusapp.ui.model.request;

public class UserLogIn {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String email) {
        this.userName = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
