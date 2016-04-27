package com.crowd.service;


import com.crowd.bean.ProjectResponse;
import com.crowd.bean.user.UserBean;
import com.crowd.dao.ProjectDAO;
import com.crowd.dao.UserDAO;
import com.crowd.entity.Project;
import com.crowd.entity.Status;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ProjectService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ProjectDAO projectDAO;

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

    public List<ProjectResponse> getUserProjects(String email){
        User user = userDAO.findByEmail(email);
        List<Project> projects = user.getProjects();
        return getWrapperProjectsInResponse(new HashSet<Project>(projects));
    }

    public int createProject(UserBean user,String projectName, double needAmount, String image, String aboutProject){
        if (image.equals("")){
            image="http://www.edisonawards.com/news/wp-content/uploads/2016/01/chi-carol-sente-crowdfunding-1871-20150302.jpg";
        }
        Project project = new Project();
        project.setNameProject(projectName);
        project.setNeedAmount(needAmount);
        project.setImage(image);
        project.setAboutProject(aboutProject);
        project.setUser(userDAO.findByEmail(user.getEmail()));
        project.setStatus(Status.NOT_STARTED);
        project.setDate(new Timestamp(System.currentTimeMillis()));
        projectDAO.insert(project);

        return project.getId();
    }


    public void checkProjectStatus(Project project){
        switch (project.getStatus()) {
            case NOT_STARTED:  {
                if (project.getDonate_amount()>0){
                    project.setStatus(Status.IN_PROGRESS);
                    update(project);
                }
            }
            break;

            case IN_PROGRESS:{
                if (project.getDonate_amount()>=project.getNeedAmount()){
                    project.setStatus(Status.FUNDED);
                    update(project);
                }
            }
                break;

            default: break;
        }
    }
}
