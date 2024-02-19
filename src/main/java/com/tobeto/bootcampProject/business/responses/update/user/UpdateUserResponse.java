package com.tobeto.bootcampProject.business.responses.update.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String nationalIdentity;
    private Date dateOfBirth;
}