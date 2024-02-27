package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.blacklist.GetAllBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;

import java.util.List;

public interface BlacklistService {
    DataResult<CreateBlacklistResponse> createBlacklist(CreateBlacklistRequest request);

    DataResult<List<GetAllBlacklistResponse>> getAllBlacklist();
}
