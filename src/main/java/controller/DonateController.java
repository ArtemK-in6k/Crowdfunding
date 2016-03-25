package controller;

import crowdfunding.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProjectService;

@Controller
@RequestMapping("/categories/{categoryId}/projects/{projectId}")
public class DonateController {
    @Autowired
    ProjectService projectService;

    @RequestMapping("/donate")
    public String hello(Model model,@PathVariable int projectId) {

        Project project = projectService.findById(projectId);

        model.addAttribute("project",project);

        return "donate";
    }
}
