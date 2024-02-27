package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.Blacklist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
