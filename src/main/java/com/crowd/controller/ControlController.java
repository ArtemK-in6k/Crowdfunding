package com.crowd.controller;


import com.crowd.bean.user.UserBean;
import com.crowd.entity.Project;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/control")
@SessionAttributes("userBean")
public class ControlController {

    @Autowired
    UserService userService;

    @RequestMapping("/projects")
    public String projects(ModelMap map, @ModelAttribute ("userBean")UserBean user) {

        List<Project> projectList = userService.findByEmail(user.getEmail()).getProjects();

        return "category";
    }
}
