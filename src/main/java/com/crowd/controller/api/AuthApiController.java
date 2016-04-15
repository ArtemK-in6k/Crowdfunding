package com.crowd.controller.api;

import com.crowd.bean.RegistrationFields;
import com.crowd.bean.SimpleRequest;
import com.crowd.service.UserDetailServiceImpl;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/auth")
public class AuthApiController {

    @Autowired
    private UserService userService;

    @Autowired private UserDetailServiceImpl userDetailsService;

    @RequestMapping(value = "/isUniqueLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> checkIsLoginUnique(@RequestBody SimpleRequest request) {
        return userService.isLoginUnique(request.getValue());
    }

    @RequestMapping(value = "/isUniqueEmail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> checkIsEmailUnique(@RequestBody SimpleRequest request) {
        return userService.isEmailUnique(request.getValue());
    }

    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public void createAccount(@RequestBody RegistrationFields registrationFields) {
         userService.createAccount(registrationFields);
    }
}
