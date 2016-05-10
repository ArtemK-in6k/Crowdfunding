package com.crowd.controller.api;

import com.crowd.bean.donate.ProjectDonatesResponse;
import com.crowd.bean.user.UserBean;
import com.crowd.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/projects")
@SessionAttributes("userBean")
public class ProjectApiController {

    @Autowired
    private DonateService donateService;

    @RequestMapping(value = "/{projectId}/donates", method = RequestMethod.GET)
    public ResponseEntity<ProjectDonatesResponse> getProjectDonates(@ModelAttribute("userBean") UserBean user, @PathVariable Integer projectId) {
        return donateService.getProjectDonates(projectId, user.getId());
    }

}
