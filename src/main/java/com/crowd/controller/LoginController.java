package com.crowd.controller;


import com.crowd.utils.Cipher;
import com.crowd.dao.UserDAO;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserDAO userDAO;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request , HttpServletResponse responser) {

        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request,responser,authentication);
        }
        return "login";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpServletRequest request , HttpServletResponse responser) {
        return "signin";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registranionUser(HttpServletRequest httpServletRequest , HttpServletResponse responser) {


        String firstName = httpServletRequest.getParameter("first_name");
        String lastName = httpServletRequest.getParameter("last_name");
        String displayName = httpServletRequest.getParameter("display_name");
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        password = Cipher.encrypt(password);

        User user = new User(firstName,lastName,email,displayName,password,"ROLE_USER",true);

        if (userDAO.findByDisplayName(displayName) == null && userDAO.findByEmail(email) == null){
            userDAO.insert(user);
        }else {
            return "error";
        }
        return "login";

    }
}
