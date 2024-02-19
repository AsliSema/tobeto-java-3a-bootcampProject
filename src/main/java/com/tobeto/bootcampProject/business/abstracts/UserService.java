package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.responses.delete.user.DeleteUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;

import java.util.List;

public interface UserService {

    List<GetAllUserResponse> getAll();

    DeleteUserResponse deleteUser(int id);
    GetUserByIdResponse getUserById(int id);

    GetUserByEmailResponse getUserByEmail(String email);


}
