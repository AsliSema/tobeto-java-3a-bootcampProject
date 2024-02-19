package com.tobeto.bootcampProject.business.requests.create.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String nationalIdentity;
    private Date dateOfBirth;
    private String about;
}