package com.crowd.bean;

import com.crowd.entity.User;
import com.crowd.utils.Cipher;

public class RegistrationFields {
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public RegistrationFields(String login, String email, String firstName, String lastName, String password) {
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public RegistrationFields(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUserEntity(){
        User user = new User();

        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(Cipher.encrypt(password));
        user.setUsername(login);
        user.setRole("ROLE_USER");

        return user;
    }
}
