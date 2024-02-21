package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.business.responses.delete.user.DeleteUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController extends BaseController{
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return handleDataResult(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
        return handleDataResult(userService.getUserById(id));
    }


    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        return handleDataResult(userService.getUserByEmail(email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        return handleDataResult(userService.deleteUser(id));
    }


}

