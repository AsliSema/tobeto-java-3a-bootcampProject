package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController {

    private ApplicantService applicantService;

    @PostMapping
    public CreateApplicantResponse createApplicant(@RequestBody CreateApplicantRequest request){
        return applicantService.createApplicant(request);
    }

    @GetMapping("/{id}")
    public GetApplicantByIdResponse getApplicant(@PathVariable int id){
        return applicantService.getApplicantById(id);
    }

    @GetMapping
    public List<GetAllApplicantResponse> gatAllApplicant(){
        return applicantService.getAllApplicant();
    }
}
