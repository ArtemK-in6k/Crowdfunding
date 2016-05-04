package com.crowd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String main(Model model, HttpSession session) {
        return "error";
    }
}
