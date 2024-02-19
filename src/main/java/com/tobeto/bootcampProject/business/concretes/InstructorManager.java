package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.tobeto.bootcampProject.business.responses.create.intructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataAccess.abstracts.InstructorRepository;
import com.tobeto.bootcampProject.entities.Instructor;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

    private InstructorRepository instructorRepository;
    private ModelMapperService mapperService;
    @Override
    public CreateInstructorResponse createInstructor(CreateInstructorRequest request) {
        Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
        instructor.setCreatedDate(LocalDateTime.now());
        instructorRepository.save(instructor);

        CreateInstructorResponse response = mapperService.forResponse().map(instructor, CreateInstructorResponse.class);
        return response;
    }


}
