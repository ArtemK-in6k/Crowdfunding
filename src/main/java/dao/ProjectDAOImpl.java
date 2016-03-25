package dao;

import crowdfunding.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    SessionFactory sessionFactory;


    public void insert(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }

    public List<Project> selectAll() {
        return null;
    }

    public Project findById(int id) {
        return null;
    }

    public void delete(Project project) {

    }

    public void update(Project project) {

    }
}
