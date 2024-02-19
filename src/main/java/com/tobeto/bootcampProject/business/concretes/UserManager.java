package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.business.responses.delete.user.DeleteUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService mapperService;

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
    public DeleteUserResponse deleteUser(int id) {
        userRepository.deleteById(id);
        DeleteUserResponse response = new DeleteUserResponse("User Deleted");
        return response;
    }

    @Override
    public GetUserByEmailResponse getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        GetUserByEmailResponse response = mapperService.forResponse().map(user, GetUserByEmailResponse.class);
        return response;
    }



}
