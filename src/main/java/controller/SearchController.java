package controller;

import crowdfunding.Project;
import crowdfunding.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProjectService;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @RequestMapping("/search")
    public String seach(Model model, HttpSession session, @RequestParam String search,@RequestParam String select) {
        List<Project> projectList;

        if (select.equals("project")){
            projectList = projectService.findByPartOfProjectName(search.toLowerCase());
            if (projectList == null){
                return "notfound";
            }
        }else {
            User user = userService.findByPartOfUserName(search.toLowerCase());
            if (user != null){
                projectList = user.getProjects();
            }else {
                return "notfound";
            }
            model.addAttribute("projectlist",projectList);
        }
        for (Project project : projectList){
            System.out.println(project.getNameProject());
        }

        return "search";
    }

}
