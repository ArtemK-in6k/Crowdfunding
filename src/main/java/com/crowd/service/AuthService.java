package com.crowd.service;


import com.crowd.entity.User;

public interface AuthService {
    User getCurrentUser();
    boolean isSameWithAuthUser(User user);
}
