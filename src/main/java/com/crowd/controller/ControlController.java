package com.crowd.controller;

import com.crowd.bean.ProjectResponse;
import com.crowd.bean.ProjectStatus;
import com.crowd.bean.donate.DonationContributionBean;
import com.crowd.bean.donate.UserDonatesBean;
import com.crowd.bean.user.UserBean;
import com.crowd.entity.Project;
import com.crowd.entity.Status;
import com.crowd.entity.User;
import com.crowd.service.DonateService;
import com.crowd.service.ProjectService;
import com.crowd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/control")
@SessionAttributes("userBean")
public class ControlController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    DonateService donateService;

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToProjects() {
        return "redirect:/control/projects";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String projects(@ModelAttribute("userBean") UserBean user) {
        return "control/projects";
    }

    @RequestMapping(value = "/projects/ownprojects", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectResponse>> getOwnProjects(@ModelAttribute("userBean") UserBean user) {

        List<ProjectResponse> responseProjects = projectService.getUserProjects(user.getEmail());

        return new ResponseEntity<List<ProjectResponse>>(responseProjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/projects/savestatus/", method = RequestMethod.POST)
    public ResponseEntity<List<ProjectResponse>> saveStatus(@ModelAttribute("userBean") UserBean user, @RequestBody ProjectStatus changeStatusProject) {

        int id = changeStatusProject.getId();
        Status status = changeStatusProject.getStatus();

        Project project = projectService.findById(id);
        project.setStatus(status);
        projectService.update(project);

        List<ProjectResponse> responseProjects = projectService.getUserProjects(user.getEmail());

        return new ResponseEntity<List<ProjectResponse>>(responseProjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/projects/{projectId}", method = RequestMethod.DELETE)
    public ResponseEntity<List<ProjectResponse>> deleteProject(@ModelAttribute("userBean") UserBean user, @PathVariable Integer projectId) {

        Project project = projectService.findById(projectId);
        projectService.delete(project);
        List<ProjectResponse> responseProjects = projectService.getUserProjects(user.getEmail());

        return new ResponseEntity<List<ProjectResponse>>(responseProjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/donates", method = RequestMethod.GET)
    public String donates(@ModelAttribute("userBean") UserBean user) {
        return "control/donates";
    }

    @RequestMapping(value = "/donates/list", method = RequestMethod.GET)
    public ResponseEntity<List<UserDonatesBean>> getOwnDonates(@ModelAttribute("userBean") UserBean user) {

        User donateOwner = userService.findByEmail(user.getEmail());
        List<UserDonatesBean> donates = donateService.getWrapperDonates(donateOwner.getDonates());

        return new ResponseEntity<List<UserDonatesBean>>(donates, HttpStatus.OK);
    }

    @RequestMapping(value = "/donates/{donateId}", method = RequestMethod.DELETE)
    public ResponseEntity<List<UserDonatesBean>> deleteDonate(@ModelAttribute("userBean") UserBean user, @PathVariable int donateId) {

        donateService.deleteDonateById(donateId);
        User donateOwner = userService.findByEmail(user.getEmail());
        List<UserDonatesBean> donates = donateService.getWrapperDonates(donateOwner.getDonates());
        return new ResponseEntity<List<UserDonatesBean>>(donates, HttpStatus.OK);
    }

    @RequestMapping(value = "/donates", method = RequestMethod.POST)
    public ResponseEntity<List<UserDonatesBean>> saveOwnDonation(@ModelAttribute("userBean") UserBean user, @RequestBody DonationContributionBean donationContributionBean) {
        donateService.saveChangeDonation(donationContributionBean);
        User donateOwner = userService.findByEmail(user.getEmail());
        List<UserDonatesBean> donates = donateService.getWrapperDonates(donateOwner.getDonates());

        return new ResponseEntity<List<UserDonatesBean>>(donates, HttpStatus.OK);
    }
}
