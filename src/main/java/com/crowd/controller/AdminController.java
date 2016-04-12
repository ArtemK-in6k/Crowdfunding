package com.crowd.controller;


import com.crowd.bean.ChangeStatusProject;
import com.crowd.bean.ProjectResponse;
import com.crowd.entity.Project;
import com.crowd.service.CategoryService;
import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToProjects(){
        return "redirect:/admin/projects";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String adminProjects(){
        return "admin/projects";
    }
    @RequestMapping(value = "/savestatus",method = RequestMethod.POST)
    public ResponseEntity<List<ProjectResponse>> saveStatus(@RequestBody ChangeStatusProject changeStatusProject, HttpServletRequest httpServletRequest){

        int id = changeStatusProject.getId();
        String status = changeStatusProject.getStatus();

        Project project = projectService.findById(id);
        project.setStatus(status);
        projectService.update(project);

        Set<Project> projects = new HashSet(projectService.selectAll());
        List<ProjectResponse> responseProject = projectService.getWrapperProjectsInResponse(projects);

        return new ResponseEntity<List<ProjectResponse>>(responseProject, HttpStatus.OK);
    }
}
