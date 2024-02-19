package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.intructor.CreateInstructorResponse;

public interface InstructorService {
    CreateInstructorResponse createInstructor(CreateInstructorRequest request);
}
