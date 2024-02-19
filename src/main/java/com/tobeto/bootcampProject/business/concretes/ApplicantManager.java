package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService mapperService;
    @Override
    public CreateApplicantResponse createApplicant(CreateApplicantRequest request) {
        Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
        applicant.setCreatedDate(LocalDateTime.now());
        applicantRepository.save(applicant);

        CreateApplicantResponse response = mapperService.forResponse().map(applicant, CreateApplicantResponse.class);

        return response;
    }

    @Override
    public GetApplicantByIdResponse getApplicantById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        GetApplicantByIdResponse response = mapperService.forResponse().map(applicant, GetApplicantByIdResponse.class);
        return response;
    }

    @Override
    public List<GetAllApplicantResponse> getAllApplicant() {
        List <Applicant> applicants = applicantRepository.findAll();
        List <GetAllApplicantResponse> response = applicants.stream().map(applicant -> mapperService.forResponse().map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());
        return response;
    }

}
