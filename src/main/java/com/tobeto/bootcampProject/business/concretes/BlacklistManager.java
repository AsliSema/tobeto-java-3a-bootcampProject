package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.blacklist.GetAllBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.Blacklist;
import com.tobeto.bootcampProject.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {

    private BlacklistRepository blacklistRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateBlacklistResponse> createBlacklist(CreateBlacklistRequest request) {
        Blacklist blacklist = mapperService.forRequest().map(request, Blacklist.class);
        blacklist.setCreatedDate(LocalDateTime.now());
        blacklistRepository.save(blacklist);

        CreateBlacklistResponse response = mapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);

        return new SuccessDataResult<CreateBlacklistResponse>(response, "Blacklist Created");
    }

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAllBlacklist() {
        List <Blacklist> blacklists = blacklistRepository.findAll();
        List <GetAllBlacklistResponse> response = blacklists.stream().map(blacklist -> mapperService.
                forResponse().map(blacklist, GetAllBlacklistResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBlacklistResponse>>(response, "All Blacklists Listed");

    }
}
