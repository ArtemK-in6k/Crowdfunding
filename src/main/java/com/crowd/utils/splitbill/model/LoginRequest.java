package com.crowd.utils.splitbill.model;

public class LoginRequest {
    private String email;

    public LoginRequest(){}

    public LoginRequest(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
