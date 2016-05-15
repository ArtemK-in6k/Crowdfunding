package com.crowd.bean.user;

/**
 * Created by AMD on 14.05.2016.
 */
public class GoogleUserBean {
    private String email;
    private String family_name;
    private String given_name;
    private String name;

    public GoogleUserBean() {
    }

    public GoogleUserBean(String email, String family_name, String given_name, String name) {
        this.email = email;
        this.family_name = family_name;
        this.given_name = given_name;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GoogleUserBean{" +
                "email='" + email + '\'' +
                ", family_name='" + family_name + '\'' +
                ", given_name='" + given_name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
