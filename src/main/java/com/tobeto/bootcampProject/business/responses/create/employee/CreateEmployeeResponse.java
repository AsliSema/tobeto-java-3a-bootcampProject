package com.tobeto.bootcampProject.business.responses.create.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private String position;
}
