package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.intructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetInstructorByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {
    private InstructorService instructorService;

    @PostMapping
    public CreateInstructorResponse createInstructor(@RequestBody CreateInstructorRequest request){
        return instructorService.createInstructor(request);
    }

    @GetMapping
    public List<GetAllInstructorResponse> getAllInstructors(){
        return instructorService.getAllInstructor();
    }

    @GetMapping("/{id}")
    public GetInstructorByIdResponse getInstructorById(@PathVariable int id){
        return instructorService.getInstructor(id);
    }

}
