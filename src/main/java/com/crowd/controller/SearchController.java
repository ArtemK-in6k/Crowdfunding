package com.crowd.controller;

import com.crowd.bean.ProjectResponse;
import com.crowd.entity.Project;
import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity<List<ProjectResponse>> search(@RequestParam String search) {
        List<Project> projectList = projectService.findByPartOfProjectName(search.toLowerCase());
        List<ProjectResponse> projects = projectService.getWrapperProjectsInResponse(new HashSet<>(projectList));

        return new ResponseEntity<List<ProjectResponse>>(projects, HttpStatus.OK);
    }

}
