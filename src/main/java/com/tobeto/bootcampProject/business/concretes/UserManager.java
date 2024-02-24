package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List <User> users = userRepository.findAll();
        List <GetAllUserResponse> userResponses = users.stream().map(user->
                mapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllUserResponse>>(userResponses, "All Users Listed");
    }



    @Override
    public DataResult<GetUserByEmailResponse> getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        GetUserByEmailResponse response = mapperService.forResponse().map(user, GetUserByEmailResponse.class);
        return new SuccessDataResult<GetUserByEmailResponse>(response, "User Listed By Email");
    }



}
