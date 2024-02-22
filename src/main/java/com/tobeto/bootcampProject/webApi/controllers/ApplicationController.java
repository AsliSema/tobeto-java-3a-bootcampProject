package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.ApplicationService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController extends BaseController{

    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<?> createApplication(@RequestBody CreateApplicationRequest request){
        return handleDataResult(applicationService.createApplication(request));
    }

    @GetMapping
    public ResponseEntity<?> getApplications(){
        return handleDataResult(applicationService.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplication(@PathVariable int id){
        return handleDataResult(applicationService.getApplication(id));
    }

    @PutMapping
    public ResponseEntity<?> updateApplication(UpdateApplicationRequest request){
        return handleDataResult(applicationService.updateApplication(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplication(@PathVariable int id){
        return handleDataResult(applicationService.deleteApplication(id));
    }
}

