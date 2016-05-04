package com.crowd.controller.api;

import com.crowd.bean.donate.ApproveDonateResponse;
import com.crowd.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/donates")
@RestController
public class DonateApiController {

    @Autowired
    private DonateService donateService;

    @RequestMapping(value = "{donateId}/approve", method = RequestMethod.POST)
    public ResponseEntity<ApproveDonateResponse> approveDonate(@PathVariable Integer donateId){
        return donateService.approveDonate(donateId);
    }

}
