package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.tobeto.bootcampProject.business.requests.delete.user.DeleteUserRequest;
import com.tobeto.bootcampProject.business.requests.update.user.UpdateUserRequest;
import com.tobeto.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService mapperService;
    @Override
    public CreateUserResponse add(CreateUserRequest request) {
        User user = this.mapperService.forRequest().map(request, User.class);
        user.setCreatedDate(LocalDateTime.now());
        userRepository.save(user);

        CreateUserResponse response = this.mapperService.forResponse().map(user, CreateUserResponse.class);
        return response;
    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List <User> users = userRepository.findAll();
        List <GetAllUserResponse> userResponses = users.stream().map(user->
                mapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return userResponses;
    }

    @Override
    public GetUserByIdResponse getUserById(int id) {
        User user = userRepository.findById(id);
        GetUserByIdResponse response = mapperService.forResponse().map(user, GetUserByIdResponse.class);
        return response;
    }

    @Override
    public UpdateUserRequest updateUser(UpdateUserRequest updateUserRequest) {
        User user = mapperService.forRequest().map(updateUserRequest, User.class);
        User updatedUser = userRepository.save(user);

        UpdateUserRequest updatedUserRequest = mapperService.forRequest().map(updatedUser, UpdateUserRequest.class);

        return updatedUserRequest;
    }

    @Override
    public DeleteUserRequest deleteUser(int id) {
        userRepository.deleteById(id);
        return null;
    }


}
