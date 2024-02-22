package com.tobeto.bootcampProject.business.responses.update.application;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationResponse {
    private int id;
    private int applicant_id;
    private int bootcamp_id;
    private int application_state_id;
}
