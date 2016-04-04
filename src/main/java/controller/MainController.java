package controller;

import crowdfunding.Category;
import crowdfunding.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CategoryService;
import service.ProjectService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = {"/main","/"})
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
