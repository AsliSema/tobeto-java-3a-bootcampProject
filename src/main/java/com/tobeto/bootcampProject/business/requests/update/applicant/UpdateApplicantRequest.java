package com.tobeto.bootcampProject.business.requests.update.applicant;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {
    private String userName;
    private String firstName;
    private String lastName;

    private Date dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String about;

}
