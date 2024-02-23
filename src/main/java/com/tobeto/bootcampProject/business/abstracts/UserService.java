package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.responses.delete.user.DeleteUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import java.util.List;

public interface UserService {

    DataResult<List<GetAllUserResponse>> getAll();

    DataResult<GetUserByIdResponse> getUserById(int id);

    DataResult<GetUserByEmailResponse> getUserByEmail(String email);

   Result deleteUser(int id);


}
