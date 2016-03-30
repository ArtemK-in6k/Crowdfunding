package controller;

import crowdfunding.Category;
import crowdfunding.Donate;
import crowdfunding.Project;
import crowdfunding.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    @RequestMapping("/create")
    public String category(Model model, HttpServletRequest httpServletRequest,
                           @RequestParam("image") MultipartFile file) throws IOException {


        int categoryId = Integer.parseInt(httpServletRequest.getParameter("categoryId"));
        String firstName = httpServletRequest.getParameter("firstname");
        String lastName = httpServletRequest.getParameter("lastname");
        String email = httpServletRequest.getParameter("email");
        double needAmount =Double.parseDouble(httpServletRequest.getParameter("needAmount"));
        String projectName = httpServletRequest.getParameter("projectName");
        String aboutProject = httpServletRequest.getParameter("aboutProject");
        double donateAmount = 0;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        byte [] image = file.getBytes();
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

        model.addAttribute("project",project);
        return "create";
    }


}
