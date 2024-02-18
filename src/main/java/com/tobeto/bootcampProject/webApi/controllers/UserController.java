package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.business.requests.create.user.CreateUserRequest;
import com.tobeto.bootcampProject.business.responses.create.user.CreateUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public CreateUserResponse add(@RequestBody CreateUserRequest request){
        CreateUserResponse result = userService.add(request);
        return result;
    }

    @GetMapping
    public List<GetAllUserResponse> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetUserByIdResponse getUser(@PathVariable int id){
        return userService.getUserById(id);
    }



}

