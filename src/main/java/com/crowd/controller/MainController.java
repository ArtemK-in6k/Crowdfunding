package com.crowd.controller;

import com.crowd.entity.Project;
import com.crowd.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping({"","/"})
public class MainController {

    @Autowired ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String main(Model model){

        List<Project> projects = projectService.selectAll();

        model.addAttribute("projects",projects);
        return "main";
    }

    @RequestMapping(value = "/angular-test", method = RequestMethod.GET)
    public String angularTestPage(){
        return "angular-test";
    }

}
