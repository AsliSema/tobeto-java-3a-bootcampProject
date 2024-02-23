package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.intructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.delete.instructor.DeleteInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetInstructorByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.webApi.controllers.BaseController;

import java.util.List;

public interface InstructorService{
    DataResult<CreateInstructorResponse> createInstructor(CreateInstructorRequest request);

    DataResult<List<GetAllInstructorResponse>> getAllInstructor();

    DataResult<GetInstructorByIdResponse> getInstructor(int id);

    DataResult<UpdateInstructorResponse> updateInstructorById(UpdateInstructorRequest request, int id);

    Result deleteInstructorById(int id);
}
