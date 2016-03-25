package dao;

import crowdfunding.User;

import java.util.List;

public interface UserDAO {
    void insert(User user);

    List<User> selectAll();

    User findById(int id);

    void delete(User user);

    void update(User user);


}

