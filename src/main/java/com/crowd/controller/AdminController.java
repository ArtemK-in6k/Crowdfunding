package com.crowd.controller;

import com.crowd.bean.ProjectStatus;
import com.crowd.entity.Status;
import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crowd.bean.ProjectResponse;
import com.crowd.entity.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/{projectId}/donates", method = RequestMethod.GET)
    public String projectDonatesList(@PathVariable Integer projectId, ModelMap map) {
        if (!projectService.isProjectExists(projectId)) {
            return "redirect:/";
        }
        map.addAttribute("projectId", projectId);
        return "admin/project/donates";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToProjects() {
        return "redirect:/admin/projects";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String adminProjects() {
        return "admin/projects";
    }

    @RequestMapping(value = "/savestatus", method = RequestMethod.POST)
    public ResponseEntity<List<ProjectResponse>> saveStatus(@RequestBody ProjectStatus changeStatusProject) {

        int id = changeStatusProject.getId();
        Status status = changeStatusProject.getStatus();

        Project project = projectService.findById(id);
        project.setStatus(status);
        projectService.update(project);

        Set<Project> projects = new HashSet(projectService.selectAll());
        List<ProjectResponse> responseProject = projectService.getWrapperProjectsInResponse(projects);

        return new ResponseEntity<List<ProjectResponse>>(responseProject, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public ResponseEntity<List<ProjectResponse>> deleteProject(@RequestBody ProjectStatus changeStatusProject) {

        int id = changeStatusProject.getId();
        Project project = projectService.findById(id);
        projectService.delete(project);

        Set<Project> projects = new HashSet(projectService.selectAll());
        List<ProjectResponse> responseProject = projectService.getWrapperProjectsInResponse(projects);

        return new ResponseEntity<List<ProjectResponse>>(responseProject, HttpStatus.OK);
    }
}
