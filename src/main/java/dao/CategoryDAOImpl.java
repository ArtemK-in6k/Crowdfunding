package dao;

import crowdfunding.Category;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements  CategoyDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void insert(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    public List<Category> selectAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from categories");
        return query.list();
    }

    public Category findById(int id) {
        Category category = sessionFactory.getCurrentSession().get(Category.class,id);
        return category;
    }

    public void delete(Category category) {
        sessionFactory.getCurrentSession().delete(category);
    }

    public void update(Category category) {
        sessionFactory.getCurrentSession().update(category);
    }

}
