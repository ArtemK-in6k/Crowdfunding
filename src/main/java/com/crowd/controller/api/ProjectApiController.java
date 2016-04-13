package com.crowd.controller.api;

import com.crowd.bean.donate.ProjectDonatesResponse;
import com.crowd.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectApiController {

    @Autowired
    private DonateService donateService;

    @RequestMapping(value = "/{projectId}/donates", method = RequestMethod.GET)
    public ResponseEntity<ProjectDonatesResponse> getProjectDonates(@PathVariable Integer projectId) {
        return donateService.getProjectDonates(projectId);
    }

}
