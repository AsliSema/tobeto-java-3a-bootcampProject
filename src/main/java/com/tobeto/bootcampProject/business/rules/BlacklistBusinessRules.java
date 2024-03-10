package com.tobeto.bootcampProject.business.rules;

import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.tobeto.bootcampProject.entities.Blacklist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BlacklistBusinessRules {

    private BlacklistRepository blacklistRepository;
    public Result checkIfApplicantInBlacklist(int applicantIdInApplication) {
        Blacklist blacklist = blacklistRepository.getByApplicantId(applicantIdInApplication);
        if(blacklist != null){
            throw new BusinessException("You Are In The Blacklist!");
        }

        return new SuccessResult();
    }
}
