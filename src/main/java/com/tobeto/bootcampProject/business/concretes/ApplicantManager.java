package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcampProject.business.rules.BusinessRules;
import com.tobeto.bootcampProject.business.rules.UserBusinessRules;
import com.tobeto.bootcampProject.core.aspects.logging.Loggable;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules userBusinessRules;
    @Override
    @Loggable
    public DataResult<CreateApplicantResponse> createApplicant(CreateApplicantRequest request) {

        var result = BusinessRules.run(userBusinessRules.checkIfUserExists(request.getEmail()), userBusinessRules.isUsernameAlreadyTaken(request.getUserName()));


        Applicant applicant = mapperService.forRequest().map(request, Applicant.class);
        applicant.setCreatedDate(LocalDateTime.now());
        applicantRepository.save(applicant);

        CreateApplicantResponse response = mapperService.forResponse().map(applicant, CreateApplicantResponse.class);

        //SuccessMessages successMessages = null;
        //return new SuccessDataResult<CreateApplicantResponse>(response, successMessages.createSuccessMessage("Applicant"));
        return new SuccessDataResult<CreateApplicantResponse>(response, "Applicant created successfully!");

    }

    @Override
    public DataResult<GetApplicantByIdResponse> getApplicantById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        GetApplicantByIdResponse response = mapperService.forResponse().map(applicant, GetApplicantByIdResponse.class);
        return new SuccessDataResult<GetApplicantByIdResponse>(response, "The Applicant Listed");
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAllApplicant() {
        List <Applicant> applicants = applicantRepository.findAll();
        List <GetAllApplicantResponse> response = applicants.stream().map(applicant -> mapperService.forResponse().map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult <List<GetAllApplicantResponse>>(response, "All Applicants Listed");
    }

    @Override
    @Loggable
    public DataResult<UpdateApplicantResponse> updateApplicantById(UpdateApplicantRequest request, int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();

        Applicant updatedApplicant = mapperService.forRequest().map(request, Applicant.class);

        applicant.setId(id);
        applicant.setUpdatedDate(LocalDateTime.now());
        applicant.setFirstName(updatedApplicant.getFirstName() != null ? updatedApplicant.getFirstName() : applicant.getFirstName());
        applicant.setLastName(updatedApplicant.getLastName() != null ? updatedApplicant.getLastName() : applicant.getLastName());
        applicant.setAbout(updatedApplicant.getAbout() != null ? updatedApplicant.getAbout() : applicant.getAbout());
        applicant.setUserName(updatedApplicant.getUserName() != null ? updatedApplicant.getUserName() : applicant.getUserName());
        applicant.setNationalIdentity(updatedApplicant.getNationalIdentity() != null ? updatedApplicant.getNationalIdentity() : applicant.getNationalIdentity());
        applicant.setDateOfBirth((updatedApplicant.getDateOfBirth() != null ? updatedApplicant.getDateOfBirth() : applicant.getDateOfBirth()));

        applicantRepository.save(applicant);
        UpdateApplicantResponse response = mapperService.forResponse().map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(response, "The Applicant Updated");
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAllSorted(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Applicant> applicants = applicantRepository.findAll(pageable);
        List <GetAllApplicantResponse> response = applicants.stream().map(applicant -> mapperService.forResponse().map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantResponse>>(response, "All Applicants Sorted");
    }

    @Override
    @Loggable
    public Result deleteApplicantById(int id) {
        applicantRepository.deleteById(id);
        return new SuccessResult("Applicant Deleted!");
    }


}
