package com.crowd.controller;

import com.crowd.entity.Category;
import com.crowd.entity.Project;
import com.crowd.service.CategoryService;
import com.crowd.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"","/"})
public class MainController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(){
        return "redirect:/main";
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main(Model model, HttpSession session) {

        List<Category> categories = categoryService.selectAll();
        List<Project> projects = projectService.selectAll();

        model.addAttribute("projects",projects);
        session.setAttribute("categories",categories);

        return "main";
    }

}
