package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.tobeto.bootcampProject.business.responses.create.user.CreateUserResponse;

public interface UserService {
    CreateUserResponse add(CreateUserRequest request);
}
