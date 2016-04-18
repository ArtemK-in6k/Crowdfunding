package com.crowd.controller;


import com.crowd.bean.user.UserBean;
import com.crowd.entity.Category;
import com.crowd.entity.Donate;
import com.crowd.entity.Project;
import com.crowd.service.CategoryService;
import com.crowd.service.DonateService;
import com.crowd.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/projects")
@SessionAttributes("userBean")
public class ProjectController {

    @Autowired ProjectService projectService;
    @Autowired CategoryService categoryService;
    @Autowired DonateService donateService;

    @RequestMapping("/{projectId}")
    public String project(Model model, @PathVariable int projectId) {

        Project project = projectService.findById(projectId);

        List<Donate> donates = project.getDonateList();

        model.addAttribute("project", project);
        model.addAttribute("donates", donates);
        model.addAttribute("categories",categoryService.selectAll());
        model.addAttribute("projectId",projectId);

        return "project";
    }

    @RequestMapping(value = "/{projectId}/donate", method = RequestMethod.POST)
    public String donate(@PathVariable int projectId,
                         @RequestParam Float amount,
                         @ModelAttribute("userBean")UserBean owner) {
        boolean isSuccess = donateService.addDonateForProject(amount, projectId, owner.getId());
        return (isSuccess) ? "redirect:/projects/" + projectId : "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProject(@ModelAttribute("userBean") UserBean user,@RequestParam String projectName, @RequestParam double needAmount,
                                @RequestParam String image, @RequestParam int category, @RequestParam String aboutProject) throws IOException {

       int projectId = projectService.createProject(user,projectName,needAmount,image,category,aboutProject);
        return "redirect:/projects/"+projectId;
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String createProjectPage() {
        return "newproject";
    }
}
