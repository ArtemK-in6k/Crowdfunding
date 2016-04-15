package com.crowd.controller;


import com.crowd.bean.RegistrationFields;
import com.crowd.service.UserDetailServiceImpl;
import com.crowd.service.UserService;
import com.crowd.utils.Cipher;
import com.crowd.dao.UserDAO;
import com.crowd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired UserDAO userDAO;

    @Autowired private UserService userService;

    @Autowired private UserDetailServiceImpl userDetailService;

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
    public String createNewAccount(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam String login, HttpSession session, ModelMap map) {


        boolean isAuthorize = userService.createAccount(new RegistrationFields(login, email, firstName, lastName, password));
        if (isAuthorize){
            reauthenticate(login, session);
        }else {
            map.addAttribute("error", "Something went wrong, check your input data!");
        }
        return "redirect:/";
    }

    private void reauthenticate(final String username, HttpSession session) {
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        Authentication auth = new UsernamePasswordAuthenticationToken (userDetails.getUsername (),userDetails.getPassword (),userDetails.getAuthorities ());
        SecurityContextHolder.getContext().setAuthentication(auth);
        session.setAttribute("userBean", userService.getUserByLogin(username));
    }
}
