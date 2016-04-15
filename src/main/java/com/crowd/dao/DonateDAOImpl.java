package com.crowd.dao;

import com.crowd.entity.Donate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DonateDAOImpl implements DonateDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void insert(Donate donate) {
        sessionFactory.getCurrentSession().save(donate);
    }

    @Override
    public void saveUpdate(Donate donate) {
        sessionFactory.getCurrentSession().saveOrUpdate(donate);
    }

    public List<Donate> selectAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from donates");
        return query.list();
    }

    public Donate findById(int id) {
        Donate donate = (Donate) sessionFactory.getCurrentSession().get(Donate.class, id);
        return donate;
    }

    public void delete(Donate donate) {
        sessionFactory.getCurrentSession().delete(donate);
    }

    public void update(Donate donate) {
        sessionFactory.getCurrentSession().update(donate);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Donate> findAllForProject(int projectId) {
        return sessionFactory.getCurrentSession().createCriteria(Donate.class, "donate")
                .createAlias("donate.project", "project")
                .add(Restrictions.eq("project.id", projectId))
                .list();
    }

    @Override
    public Donate findByDonatorAndProject(int donatorId, int projectId) {
        return (Donate) sessionFactory.getCurrentSession().createCriteria(Donate.class, "donate")
                .createAlias("donate.project", "project")
                .createAlias("donate.user", "user")
                .add(Restrictions.and(
                        Restrictions.eq("project.id", projectId),
                        Restrictions.eq("user.id", donatorId)
                ))
                .uniqueResult();
    }
}
