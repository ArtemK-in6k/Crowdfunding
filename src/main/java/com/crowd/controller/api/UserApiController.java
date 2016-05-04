package com.crowd.controller.api;

import com.crowd.bean.user.ChangePasswordRequest;
import com.crowd.bean.user.ChangePasswordResponse;
import com.crowd.bean.user.UserBean;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/")
@SessionAttributes("userBean")
public class UserApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public ChangePasswordResponse changePassword(@ModelAttribute("userBean") UserBean userBean, @RequestBody ChangePasswordRequest changePasswordRequest) {
        return userService.changePasswordForUser(userBean.getId(), changePasswordRequest);
    }

}
