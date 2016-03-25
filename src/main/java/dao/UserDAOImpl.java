package dao;

import crowdfunding.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void insert(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> selectAll() {
        return null;
    }

    public User findById(int id) {
        return null;
    }

    public void delete(User user) {

    }

    public void update(User user) {

    }
}
