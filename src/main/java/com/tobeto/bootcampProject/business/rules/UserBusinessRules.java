package com.tobeto.bootcampProject.business.rules;

import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private UserRepository userRepository;

    public Result checkIfUserExists(String email){
        User user = userRepository.findByEmail(email.trim());
        if(user != null){
                throw new BusinessException("User already exists!");
            }
            return new SuccessResult();
    }

    public Result isUsernameAlreadyTaken(String username) {
        User user = userRepository.findByUserName(username.trim());
        if(user != null){
            throw new BusinessException("User name already taken!");
        }
        return new SuccessResult();
    }
}
