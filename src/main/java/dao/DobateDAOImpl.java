package dao;

import crowdfunding.Donate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DobateDAOImpl implements DonateDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void insert(Donate donate) {
        sessionFactory.getCurrentSession().save(donate);
    }

    public List<Donate> selectAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from donates");
        return query.list();
    }

    public Donate findById(int id) {
        return null;
    }

    public void delete(Donate donate) {

    }

    public void update(Donate donate) {

    }
}
