package controller;

import crowdfunding.Project;
import crowdfunding.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CategoryService;
import service.ProjectService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/search")
    public String seach(Model model, HttpSession session, @RequestParam String search, @RequestParam String select, HttpServletRequest httpServletRequest) {
        List<Project> projectList = new ArrayList<Project>();

        if (select.equals("project")){
            projectList = projectService.findByPartOfProjectName(search.toLowerCase());
            if (projectList == null || projectList.size()<1){
                return "notfound";
            }
        }else if (select.equals("user")){
            List<User> users = userService.findByPartOfUserName(search.toLowerCase());
            if (users != null || users.size()<1){
                for (User user : users){
                    projectList.addAll(user.getProjects());
                }
            }else {
                return "notfound";
            }

        }else {
            return "notfound";
        }

        model.addAttribute("projectlist",projectList);
        model.addAttribute("search",search);
        model.addAttribute("categories",categoryService.selectAll());

        return "search";
    }

}
