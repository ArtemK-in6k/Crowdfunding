package controller;


import crowdfunding.Donate;
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
import java.sql.Timestamp;

@Controller
public class ThanksController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    DonateService donateService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/thanks", method = RequestMethod.POST)
    public String thanks(Model model, HttpServletRequest httpServletRequest) {


        int projectId = Integer.parseInt(httpServletRequest.getParameter("projectId"));
        String firstName = httpServletRequest.getParameter("firstname");
        String lastName = httpServletRequest.getParameter("lastname");
        String email = httpServletRequest.getParameter("email");
        double donateAmount =Double.parseDouble(httpServletRequest.getParameter("donate"));

        User user;
        Project project = projectService.findById(projectId);

        if (userService.findByEmail(email) == null){
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            userService.insert(user);
        }

        double donateAmountInDB = project.getDonate_amount();
        donateAmountInDB += donateAmount;
        project.setDonate_amount(donateAmountInDB);

        projectService.update(project);

        user = userService.findByEmail(email);

        Donate donate = new Donate();
        donate.setAmount(donateAmount);
        donate.setDate(new Timestamp(System.currentTimeMillis()));
        donate.setUser(user);
        donate.setProjectId(project);

        donateService.insert(donate);

        model.addAttribute("project",project);
        model.addAttribute("categories",categoryService.selectAll());

        return "thanks";
    }
}
