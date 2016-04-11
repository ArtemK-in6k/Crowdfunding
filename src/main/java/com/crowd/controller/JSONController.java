package com.crowd.controller;

import com.crowd.bean.ProjectResponse;
import com.crowd.entity.Category;
import com.crowd.entity.Project;
import com.crowd.service.CategoryService;
import com.crowd.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;


@Controller
public class JSONController {

    @Autowired
    ProjectService projectService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<ProjectResponse>> getProjectsInJSON() {

        List<ProjectResponse> projects = projectService.getAllProjects();

        return new ResponseEntity<List<ProjectResponse>>(projects, HttpStatus.OK);
    }

    @RequestMapping(value = "categories/{categoryId}/categoryProjects", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<ProjectResponse>> getCategoryProjectsInJSON(@PathVariable int categoryId) {
        System.out.println(categoryId);
        Category category = categoryService.findById(categoryId);
        Set<Project> projects = category.getProjects();
        List<ProjectResponse> responseProject = projectService.getWrapperProjectsInResponse(projects);

        System.out.println(responseProject);
        return new ResponseEntity<List<ProjectResponse>>(responseProject, HttpStatus.OK);


    }
}
