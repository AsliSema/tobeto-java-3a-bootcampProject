package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlacklistController extends BaseController{
    private BlacklistService blacklistService;

    @PostMapping
    public ResponseEntity<?> createBlacklist(@RequestBody CreateBlacklistRequest request){
        return handleDataResult(blacklistService.createBlacklist(request));
    }


    @GetMapping
    public ResponseEntity<?> getAllBlacklists(){
        return handleDataResult(blacklistService.getAllBlacklist());
    }

}
