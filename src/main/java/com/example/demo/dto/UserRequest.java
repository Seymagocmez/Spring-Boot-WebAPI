package com.example.demo.dto;

public class UserRequest {
    private String userName;
    private String userPassword;

    // Boş constructor (JSON deserialize için)
    public UserRequest() {}

    // Getter ve Setterlar
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
