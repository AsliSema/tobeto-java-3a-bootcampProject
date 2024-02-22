package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.bootcampState.UpdateBootcampStateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bootcampStates")
@AllArgsConstructor
public class BootcampStateController extends BaseController{

    private BootcampStateService bootcampStateService;
    @PostMapping
    public ResponseEntity<?> createBootcampState(@RequestBody CreateBootcampStateRequest request){
        return handleDataResult(bootcampStateService.createBootcampState(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllBootcampStates(){
        return handleDataResult(bootcampStateService.getAllBootcampStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBootcampState(@PathVariable int id){
        return handleDataResult(bootcampStateService.getBootcampState(id));
    }

    @PutMapping
    public ResponseEntity<?> updateBootcampState(UpdateBootcampStateRequest request){
        return handleDataResult(bootcampStateService.updateBootcampState(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBootcampState(@PathVariable int id){
        return handleDataResult(bootcampStateService.deleteBootcampState(id));
    }

}
