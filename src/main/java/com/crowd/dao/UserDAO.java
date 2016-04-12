package com.crowd.dao;


import com.crowd.entity.User;

import java.util.List;

public interface UserDAO {
    void insert(User user);

    List<User> selectAll();

    User findById(int id);

    void delete(User user);

    void update(User user);

    User findByEmail(String email);

    User findByDisplayName(String displayName);

    List findByPartOfUserName(String userName);

    User findByLogin(String login);
}

