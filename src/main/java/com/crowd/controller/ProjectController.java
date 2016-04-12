package com.crowd.controller;


import com.crowd.entity.Donate;
import com.crowd.entity.Project;
import com.crowd.service.CategoryService;
import com.crowd.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/{projectId}")
    public String project(Model model, @PathVariable int projectId) {

        Project project = projectService.findById(projectId);

        List<Donate> donates = project.getDonateList();

        model.addAttribute("project", project);
        model.addAttribute("donates", donates);
        model.addAttribute("categories",categoryService.selectAll());
        model.addAttribute("projectId",projectId);
        System.out.println(projectId);

        return "project";
    }

    @RequestMapping(value = "/{projectId}/donate", method = RequestMethod.GET)
    public String donate(Model model,@PathVariable int projectId) {

        Project project = projectService.findById(projectId);

        model.addAttribute("projectId",projectId);
        model.addAttribute("project",project);
        model.addAttribute("categories",categoryService.selectAll());

        return "donate";
    }
}
