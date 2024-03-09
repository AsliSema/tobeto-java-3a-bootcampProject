package com.tobeto.bootcampProject.business.rules;

import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import com.tobeto.bootcampProject.entities.BootcampState;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BootcampBusinessRules {
    private UserRepository userRepository;
    private BootcampStateRepository bootcampStateRepository;
    public Result checkIfInstructorExists(int constructorId){
        User user = userRepository.findById(constructorId);
        if(user == null){
            throw new BusinessException("Instructor couldn't found!");
        }
        return new SuccessResult();
    }

    public Result checkIfBootcampStateExists(int bootcampStateId){
        BootcampState bootcampState = bootcampStateRepository.findById(bootcampStateId);

        if(bootcampState == null){
            throw new BusinessException("Bootcamp state couldn't found!");
        }

        return new SuccessResult();

    }
}
