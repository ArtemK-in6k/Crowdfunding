package service;

import crowdfunding.User;
import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public User findByPartOfUserName(String userName) {
        String[] usersName = userName.split(" ");
        User user;

        if (usersName.length == 1){
            user = userDAO.findByPartOfUserName(userName);
        }else if (usersName.length == 2){
            user = userDAO.findByPartOfUserName(usersName[0]+usersName[1]);
            if (user == null){
                user = userDAO.findByPartOfUserName(usersName[1]+usersName[2]);
            }
        }else {
            user = null;
        }

        return user;
    }

}
