package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.business.responses.delete.user.DeleteUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<GetAllUserResponse> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetUserByIdResponse getUser(@PathVariable int id){
        return userService.getUserById(id);
    }


    @DeleteMapping("/{id}")
    public DeleteUserResponse deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public GetUserByEmailResponse getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

}

