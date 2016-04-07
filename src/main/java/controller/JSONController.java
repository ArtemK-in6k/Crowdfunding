package controller;

import bean.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProjectService;

import java.util.List;


@Controller
public class JSONController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<ProjectResponse>> getProjectsInJSON() {

        List<ProjectResponse> projectBeanses = projectService.getAllProjects();

        return new ResponseEntity<List<ProjectResponse>>(projectBeanses, HttpStatus.OK);
    }
}
