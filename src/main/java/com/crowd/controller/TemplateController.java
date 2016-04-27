package com.crowd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/templates")
public class TemplateController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String template(@PathVariable String name) {
        return name;
    }
}
