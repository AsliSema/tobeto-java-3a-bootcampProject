package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.intructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.delete.instructor.DeleteInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetInstructorByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.InstructorRepository;
import com.tobeto.bootcampProject.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

    private InstructorRepository instructorRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateInstructorResponse> createInstructor(CreateInstructorRequest request) {
        Instructor instructor = mapperService.forRequest().map(request, Instructor.class);
        instructor.setCreatedDate(LocalDateTime.now());
        instructorRepository.save(instructor);

        CreateInstructorResponse response = mapperService.forResponse().map(instructor, CreateInstructorResponse.class);
        return new SuccessDataResult<CreateInstructorResponse>(response, "Instructor Created");
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAllInstructor() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorResponse> response = instructors.stream().map(instructor -> mapperService.forResponse().map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllInstructorResponse>>(response, "All Instructors Listed");
    }

    @Override
    public DataResult<GetInstructorByIdResponse> getInstructor(int id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        GetInstructorByIdResponse response = mapperService.forResponse().map(instructor, GetInstructorByIdResponse.class);
        return new SuccessDataResult<GetInstructorByIdResponse>(response, "Instructor Listed");
    }

    @Override
    public DataResult<UpdateInstructorResponse> updateInstructorById(UpdateInstructorRequest request, int id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow();

        Instructor updatedInstructor = mapperService.forRequest().map(request, Instructor.class);

        instructor.setId(id);
        instructor.setUpdatedDate(LocalDateTime.now());
        instructor.setFirstName(updatedInstructor.getFirstName() != null ? updatedInstructor.getFirstName() : instructor.getFirstName());
        instructor.setLastName(updatedInstructor.getLastName() != null ? updatedInstructor.getLastName() : instructor.getLastName());
        instructor.setUserName(updatedInstructor.getUserName() != null ? updatedInstructor.getUserName() : instructor.getUserName());
        instructor.setNationalIdentity(updatedInstructor.getNationalIdentity() != null ? updatedInstructor.getNationalIdentity() : instructor.getNationalIdentity());
        instructor.setDateOfBirth((updatedInstructor.getDateOfBirth() != null ? updatedInstructor.getDateOfBirth() : instructor.getDateOfBirth()));
        instructor.setCompanyName(updatedInstructor.getCompanyName() != null ? updatedInstructor.getCompanyName() : instructor.getCompanyName());

        instructorRepository.save(instructor);
        UpdateInstructorResponse response = mapperService.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response, "Instructor Updated");
    }

    @Override
    public DataResult<DeleteInstructorResponse> deleteInstructorById(int id) {
        instructorRepository.deleteById(id);
        //DeleteInstructorResponse response = new DeleteInstructorResponse("Instructor Deleted");
        return new SuccessDataResult<DeleteInstructorResponse>("Instructor Deleted!");
    }


}
