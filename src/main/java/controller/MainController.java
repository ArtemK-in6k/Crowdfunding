package controller;

import crowdfunding.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String hello(Model model, HttpSession session) {

        List<User> categories = userService.selectAll();

        return "main";
    }
}
