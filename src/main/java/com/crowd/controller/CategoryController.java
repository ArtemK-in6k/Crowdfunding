package com.crowd.controller;

import com.crowd.entity.Category;
import com.crowd.entity.Project;
import com.crowd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/{id}")
    public String category(Model model,@PathVariable int id) {
        List<Category> categories = categoryService.selectAll();

        Category category = categoryService.findById(id);
        Set<Project> projects = category.getProjects();

        model.addAttribute("idcategory",id);
        model.addAttribute("projects",projects);
        model.addAttribute("category",category);
        model.addAttribute("categories",categoryService.selectAll());

        return "category";
    }

    @RequestMapping("/{id}/newproject")
    public String newProject(Model model, @PathVariable int id) {

        Category category = categoryService.findById(id);

        model.addAttribute("category",category);
        model.addAttribute("categories",categoryService.selectAll());

        return "newproject";
    }

}
