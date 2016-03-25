package controller;

import crowdfunding.Category;
import crowdfunding.Project;
import crowdfunding.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CategoryService;
import service.ProjectService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProjectService projectService;

    @RequestMapping("/")
    public String hello(Model model, HttpSession session) {

        List<Category> categories = categoryService.selectAll();
        List<Project> projects = projectService.selectAll();

        model.addAttribute("projects",projects);
        model.addAttribute("categories",categories);


        System.out.println(projects.toArray().toString());

        return "main";
    }
}
