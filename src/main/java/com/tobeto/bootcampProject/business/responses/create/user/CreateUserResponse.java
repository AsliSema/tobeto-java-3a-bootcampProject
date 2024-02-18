package com.tobeto.bootcampProject.business.responses.create.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class CreateUserResponse {
    private String firstName;
    private String lastName;
    private String userName;


}
