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

}
