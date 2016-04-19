package com.crowd.service;


import com.crowd.bean.ProjectResponse;
import com.crowd.bean.user.UserBean;
import com.crowd.dao.CategoryDAOImpl;
import com.crowd.dao.CategoyDAO;
import com.crowd.dao.ProjectDAO;
import com.crowd.dao.UserDAO;
import com.crowd.entity.Category;
import com.crowd.entity.Project;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private CategoyDAO categoryDao;

    public List<Project> selectAll() {
        return projectDAO.selectAll();
    }

    public Project findById(int id) {
        return projectDAO.findById(id);
    }

    public Project findByProjectName(String projectName) {
        return projectDAO.findByProjectName(projectName);
    }

    public void update(Project project) {
        projectDAO.update(project);
    }

    public void insert(Project project) {
        projectDAO.insert(project);
    }

    public void delete(Project project) {
        projectDAO.delete(project);
    }

    public List<Project> findByPartOfProjectName(String projectName) {
        projectName = projectName.replaceAll(" ", "");
        return projectDAO.findByPartOfProjectName(projectName);
    }

    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = projectDAO.selectAll();
        List<ProjectResponse> projectResponses = new ArrayList<ProjectResponse>();
        for (Project project : projects) {
            projectResponses.add(new ProjectResponse(project));
        }
        return projectResponses;
    }

    public List<ProjectResponse> getWrapperProjectsInResponse(Set<Project> projects) {
        List projectResponses = new ArrayList<ProjectResponse>();
        for (Project project : projects) {
            projectResponses.add(new ProjectResponse(project));
        }
        return projectResponses;
    }

    public boolean isProjectExists(int projectId) {
        return !Objects.isNull(projectDAO.findById(projectId));
    }

    public ResponseEntity<Set<ProjectResponse>> getProjectsByCategory(int categoryId) {
        Category category = categoryDao.findById(categoryId);
        Set<Project> projects = (Objects.isNull(category)) ? new HashSet<>() : category.getProjects();
        return new ResponseEntity<Set<ProjectResponse>>(projects
                .stream().map(ProjectResponse::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

    public List<ProjectResponse> getUserProjects(String email){
        User user = userDAO.findByEmail(email);
        List<Project> projects = user.getProjects();
        return getWrapperProjectsInResponse(new HashSet<Project>(projects));
    }

    public int createProject(UserBean user,String projectName, double needAmount, String image, int categoryId, String aboutProject){
        if (image.equals("")){
            image="http://www.edisonawards.com/news/wp-content/uploads/2016/01/chi-carol-sente-crowdfunding-1871-20150302.jpg";
        }
        Project project = new Project();
        project.setNameProject(projectName);
        project.setNeedAmount(needAmount);
        project.setImage(image);
        project.setCategory(categoryDao.findById(categoryId));
        project.setAboutProject(aboutProject);
        project.setUser(userDAO.findByEmail(user.getEmail()));
        project.setStatus("Actual");
        project.setDate(new Timestamp(System.currentTimeMillis()));
        projectDAO.insert(project);

        return project.getId();
    }
}
