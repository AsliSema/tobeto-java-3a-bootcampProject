package com.tobeto.bootcampProject.business.rules;

import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import com.tobeto.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import com.tobeto.bootcampProject.entities.ApplicationState;
import com.tobeto.bootcampProject.entities.Bootcamp;
import com.tobeto.bootcampProject.entities.BootcampState;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationBusinessRules {

    private UserRepository userRepository;
    private ApplicationStateRepository applicationStateRepository;
    private BootcampRepository bootcampRepository;
    public Result checkIfApplicantExists(int applicantId){
        User user = userRepository.findById(applicantId);
        if(user == null){
            throw new BusinessException("Applicant couldn't found");
        }
        return new SuccessResult();
    }

    public Result checkIfApplicationStateExists(int bootcampStateId){
        ApplicationState applicationState = applicationStateRepository.findById(bootcampStateId);

        if(applicationState == null){
            throw new BusinessException("Application state couldn't found!");
        }

        return new SuccessResult();

    }

    public Result checkIfBootcampExists(int bootcampId){
        Bootcamp bootcamp = bootcampRepository.findById(bootcampId);

        if(bootcamp == null){
            throw new BusinessException("Bootcamp couldn't found!");
        }

        return new SuccessResult();

    }


}
