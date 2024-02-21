package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.delete.applicant.DeleteApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController extends BaseController{

    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> createApplicant(@RequestBody CreateApplicantRequest request){
        return handleDataResult(applicantService.createApplicant(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicant(@PathVariable int id){
        return handleDataResult(applicantService.getApplicantById(id));
    }

    @GetMapping
    public ResponseEntity<?> gatAllApplicant(){
        return handleDataResult(applicantService.getAllApplicant());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateApplicant(@Valid @RequestBody UpdateApplicantRequest request, @PathVariable int id){
        return handleDataResult(applicantService.updateApplicantById(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplicant(@PathVariable int id){
        return handleDataResult(applicantService.deleteApplicantById(id));
    }
}
