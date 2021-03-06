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
    @Autowired
    private AuthService authService;

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
        if (project.getStatus().equals(Status.NOT_STARTED) ||  project.getStatus().equals(Status.IN_PROGRESS)){
            projectDAO.delete(project);
        }

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

    public List<ProjectResponse> getUserProjects(String email) {
        User user = userDAO.findByEmail(email);
        List<Project> projects = user.getProjects();
        return getWrapperProjectsInResponse(new HashSet<Project>(projects));
    }

    public int createProject(UserBean user, String projectName, double needAmount, String image, String aboutProject, String url) {
        Project project = new Project();
        project.setName(projectName);
        project.setNeedAmount(needAmount);
        project.setAboutProject(aboutProject);
        project.setImage(image);
        project.setUser(userDAO.findByEmail(user.getEmail()));
        project.setStatus(Status.NOT_STARTED);
        project.setDate(new Timestamp(System.currentTimeMillis()));
        project.setUrl(url);
        projectDAO.insert(project);

        return project.getId();
    }


    public void checkProjectStatus(Project project) {
        switch (project.getStatus()) {
            case NOT_STARTED: {
                if (project.getDonate_amount() >= project.getNeedAmount()) {
                    project.setStatus(Status.FUNDED);
                } else if (project.getDonate_amount() > 0) {
                    project.setStatus(Status.IN_PROGRESS);
                }
                update(project);
            }
            break;

            case IN_PROGRESS: {
                if (project.getDonate_amount() >= project.getNeedAmount()) {
                    project.setStatus(Status.FUNDED);
                }
                update(project);
            }
                break;

            default: break;
        }
    }

    public ProjectResponse getProjectById(int projectId){
        ProjectResponse projectResponse = new ProjectResponse(projectDAO.findById(projectId));
        projectResponse.isEditable(authService.isSameWithAuthUser(userDAO.findById(projectResponse.getUserId())));
        return projectResponse;
    }
}
