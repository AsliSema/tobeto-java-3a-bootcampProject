package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantByIdResponse;

import java.util.List;

public interface ApplicantService {
    CreateApplicantResponse createApplicant(CreateApplicantRequest request);

    GetApplicantByIdResponse getApplicantById(int id);

    List<GetAllApplicantResponse> getAllApplicant();
}
