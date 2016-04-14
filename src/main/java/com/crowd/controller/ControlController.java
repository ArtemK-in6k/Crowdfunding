package com.crowd.controller;

import com.crowd.bean.ProjectResponse;
import com.crowd.bean.ProjectStatus;
import com.crowd.bean.user.UserBean;
import com.crowd.entity.Project;
import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/control")
@SessionAttributes("userBean")
public class ControlController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToProjects() {
        return "redirect:/control/projects";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String projects(@ModelAttribute("userBean") UserBean user) {
        return "control/projects";
    }

    @RequestMapping(value = "/projects/ownprojects", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectResponse>> getOwnProjects(@ModelAttribute("userBean") UserBean user) {

        List<Project> projects = userService.findByEmail(user.getEmail()).getProjects();

        List<ProjectResponse> responseProjects = projectService.getWrapperProjectsInResponse(new HashSet<Project>(projects));

        return new ResponseEntity<List<ProjectResponse>>(responseProjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/projects/savestatus/", method = RequestMethod.POST)
    public ResponseEntity<List<ProjectResponse>> saveStatus(@RequestBody ProjectStatus changeStatusProject) {

        int id = changeStatusProject.getId();
        String status = changeStatusProject.getStatus();

        Project project = projectService.findById(id);
        project.setStatus(status);
        projectService.update(project);

        Set<Project> projects = new HashSet(projectService.selectAll());
        List<ProjectResponse> responseProject = projectService.getWrapperProjectsInResponse(projects);

        return new ResponseEntity<List<ProjectResponse>>(responseProject, HttpStatus.OK);
    }

    @RequestMapping(value = "/projects/deleteProject/", method = RequestMethod.POST)
    public ResponseEntity<List<ProjectResponse>> deleteProject(@RequestBody ProjectStatus changeStatusProject) {

        int id = changeStatusProject.getId();
        Project project = projectService.findById(id);
        projectService.delete(project);

        Set<Project> projects = new HashSet(projectService.selectAll());
        List<ProjectResponse> responseProject = projectService.getWrapperProjectsInResponse(projects);

        return new ResponseEntity<List<ProjectResponse>>(responseProject, HttpStatus.OK);
    }
}