package com.crowd.utils.splitbill.model.response;


import com.crowd.utils.splitbill.model.user.User;

public class UserResponse {
    private int status;
    private String message;
    private User data;

    public UserResponse(){}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
