package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.tobeto.bootcampProject.business.requests.update.user.UpdateUserRequest;
import com.tobeto.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;

import java.util.List;

public interface UserService {
    CreateUserResponse add(CreateUserRequest request);

    List<GetAllUserResponse> getAll();

    GetUserByIdResponse getUserById(int id);

    UpdateUserRequest updateUser(UpdateUserRequest updateUserRequest);


}
