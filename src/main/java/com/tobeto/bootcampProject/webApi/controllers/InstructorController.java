package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.intructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.delete.employee.DeleteEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.delete.instructor.DeleteInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetInstructorByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController extends BaseController{
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> createInstructor(@RequestBody CreateInstructorRequest request){
        return handleDataResult(instructorService.createInstructor(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllInstructors(){
        return handleDataResult(instructorService.getAllInstructor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable int id){
        return handleDataResult(instructorService.getInstructor(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(@RequestBody UpdateInstructorRequest request, @PathVariable int id){
        return handleDataResult(instructorService.updateInstructorById(request, id));
    }

    @DeleteMapping("/{id}")
    public DeleteInstructorResponse deleteInstructor(@PathVariable int id){
        return instructorService.deleteInstructorById(id);
    }

}
