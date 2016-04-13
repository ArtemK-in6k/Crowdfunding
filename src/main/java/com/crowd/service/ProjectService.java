package com.crowd.service;


import com.crowd.bean.ProjectResponse;
import com.crowd.dao.ProjectDAO;
import com.crowd.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProjectService {
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

    public void delete(Project project) {projectDAO.delete(project);}

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
}
