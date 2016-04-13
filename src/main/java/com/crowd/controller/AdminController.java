package com.crowd.controller;

import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/{projectId}/donates", method = RequestMethod.GET)
    public String projectDonatesList(@PathVariable Integer projectId, ModelMap map){
        if(!projectService.isProjectExists(projectId)){
            return "redirect:/";
        }
        map.addAttribute("projectId", projectId);
        return "admin/project/donates";
    }

}
