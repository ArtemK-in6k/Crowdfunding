package controller;

import crowdfunding.Category;
import crowdfunding.Project;
import crowdfunding.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CategoryService;
import service.ProjectService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class MainController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProjectService projectService;


    @RequestMapping
    public String main(Model model, HttpSession session) {

        List<Category> categories = categoryService.selectAll();
        List<Project> projects = projectService.selectAll();

        model.addAttribute("projects",projects);
        session.setAttribute("categories",categories);

        return "main";
    }

}
