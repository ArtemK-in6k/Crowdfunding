package com.crowd.service;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.user.UserBean;
import com.crowd.dao.UserDAO;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public ResponseEntity<Boolean> isLoginUnique(String login){
        login = login.trim();
        return new ResponseEntity<Boolean>(Objects.isNull(userDAO.findByLogin(login)), HttpStatus.OK);
    }

    public ResponseEntity<Boolean> isEmailUnique(String email) {
        email = email.trim();
        return new ResponseEntity<Boolean>(Objects.isNull(userDAO.findByEmail(email)), HttpStatus.OK);
    }

    public boolean createAccount(RegistrationFields registrationFields) {
        boolean isAuthorize = false;
        User newUser = registrationFields.toUserEntity();

        if (!Objects.isNull(newUser)){
            userDAO.insert(newUser);
            isAuthorize = true;
        }

        return isAuthorize;
    }

}
