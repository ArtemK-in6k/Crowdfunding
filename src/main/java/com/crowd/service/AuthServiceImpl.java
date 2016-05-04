package com.crowd.service;

import com.crowd.dao.UserDAO;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userDAO.findByLogin(auth.getName());
        return currentUser;
    }

    @Override
    public boolean isSameWithAuthUser(User user) {
        return user.getUsername().equals(getCurrentUser().getUsername());
    }
}
