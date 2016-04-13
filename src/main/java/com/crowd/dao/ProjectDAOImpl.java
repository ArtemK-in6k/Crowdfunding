package com.crowd.dao;

import com.crowd.entity.Project;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

        Query query = sessionFactory.getCurrentSession().createQuery("from projects");
        return query.list();
    }

    public Project findById(int id) {
        Project project = (Project) sessionFactory.getCurrentSession().get(Project.class,id);
        return project;
    }
    public Project findByProjectName(String nameProject) {
        Query query = sessionFactory.getCurrentSession().createQuery("from projects where nameProject = :nameProject");
        query.setString("nameProject",nameProject);
        return (Project) query.uniqueResult();
    }

    public void delete(Project project) {
        sessionFactory.getCurrentSession().delete(project);
    }

    public void update(Project project) {
        sessionFactory.getCurrentSession().update(project);
    }

    public List<Project> findByPartOfProjectName(String projectName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from projects where lower(nameProject) like :projectName");
        query.setString("projectName","%"+projectName+"%");
        return query.list();
    }

    @Override
    public List<Project> findAllByCategory(int category) {
      return   sessionFactory.getCurrentSession().createCriteria(Project.class, "project")
                .createAlias("project.category", "category")
                .add(Restrictions.eq("category.id",category))
                .list();
    }
}
