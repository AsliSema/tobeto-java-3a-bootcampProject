package com.tobeto.bootcampProject.business.requests.create.application;

import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.ApplicationState;
import com.tobeto.bootcampProject.entities.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {
    private int applicant_id;
    private int bootcamp_id;
    private int application_state_id;
}
