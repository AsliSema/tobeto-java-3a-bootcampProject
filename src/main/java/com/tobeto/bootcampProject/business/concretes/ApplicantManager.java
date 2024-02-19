package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
