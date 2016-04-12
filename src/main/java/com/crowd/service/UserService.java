package com.crowd.service;

import com.crowd.bean.user.UserBean;
import com.crowd.dao.UserDAO;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> selectAll() {
        return userDAO.selectAll();
    }

    public void insert(User user){
        userDAO.insert(user);
    }

    public User findByEmail(String email){
        return userDAO.findByEmail(email);
    }

    public List<User> findByPartOfUserName(String userName) {
        String[] usersName = userName.split(" ");
        List<User> users = new ArrayList<User>();

        if (usersName.length == 1){
            users = userDAO.findByPartOfUserName(userName);
        }else if (usersName.length == 2){
            users = userDAO.findByPartOfUserName(usersName[0]+usersName[1]);
            users.addAll(userDAO.findByPartOfUserName(usersName[1]+usersName[0]));
        }

        return users;
    }

    public UserBean getUserByLogin(String login){
        return new UserBean(userDAO.findByLogin(login));
    }
}
