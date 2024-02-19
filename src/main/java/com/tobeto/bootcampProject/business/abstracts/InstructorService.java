package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.intructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetInstructorByIdResponse;

import java.util.List;

public interface InstructorService {
    CreateInstructorResponse createInstructor(CreateInstructorRequest request);

    List<GetAllInstructorResponse> getAllInstructor();

    GetInstructorByIdResponse getInstructor(int id);
}
