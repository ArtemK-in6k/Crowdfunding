package com.crowd.dao;

import com.crowd.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Query query = sessionFactory.getCurrentSession().createQuery("from users ");
        return query.list();
    }

    public User findById(int id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class,id);
        return user;
    }

    public User findByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from users where email = :email");
        query.setString("email",email);
        return (User)query.uniqueResult();
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public List<User> findByPartOfUserName(String userName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from users where lower(CONCAT (firstName, lastName)) like :userName");
        query.setString("userName","%"+userName+"%");
        return query.list();
    }

    @Override
    public User findByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("username", login))
                .uniqueResult();
    }

    public User findByDisplayName(String displayName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from users where username = :displayName");
        query.setString("displayName",displayName);
        return (User)query.uniqueResult();
    }
}
