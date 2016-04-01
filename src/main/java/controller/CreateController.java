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
import service.DonateService;
import service.ProjectService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;

@Controller
@RequestMapping
public class CreateController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    DonateService donateService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String category(Model model, HttpServletRequest httpServletRequest) throws IOException {


        int categoryId = Integer.parseInt(httpServletRequest.getParameter("categoryId"));
        String firstName = httpServletRequest.getParameter("firstname");
        String lastName = httpServletRequest.getParameter("lastname");
        String email = httpServletRequest.getParameter("email");
        double needAmount =Double.parseDouble(httpServletRequest.getParameter("needAmount"));
        String projectName = httpServletRequest.getParameter("projectName");
        String aboutProject = httpServletRequest.getParameter("aboutProject");
        String image = httpServletRequest.getParameter("image");
        double donateAmount = 0;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Category category = categoryService.findById(categoryId);

        User user;
        Project project;

        if (userService.findByEmail(email) == null){
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            userService.insert(user);
        }else {
            user = userService.findByEmail(email);
        }

        if (projectService.findByProjectName(projectName) == null){
            project = new Project();
            project.setUser(user);
            project.setCategory(category);
            project.setAboutProject(aboutProject);
            project.setDonate_amount(donateAmount);
            project.setNeedAmount(needAmount);
            project.setNameProject(projectName);
            project.setImage(image);
            project.setDate(timestamp);
            projectService.insert(project);
        }else {
            return "error";
        }

        model.addAttribute("categories",categoryService.selectAll());
        model.addAttribute("project",project);
        return "create";
    }


}
