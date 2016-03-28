package controller;


import crowdfunding.Donate;
import crowdfunding.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProjectService;

import java.util.List;

@Controller
@RequestMapping("/categories/{categoryId}/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping("/{projectId}")
    public String project(Model model, @PathVariable int projectId) {

        Project project = projectService.findById(projectId);

        List<Donate> donates = project.getDonateList();

        model.addAttribute("project", project);
        model.addAttribute("donates", donates);

        return "project";
    }
}
