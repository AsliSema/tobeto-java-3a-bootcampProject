package com.tobeto.bootcampProject.business.requests.update.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {
    private int id;
    private int applicant_id;
    private int bootcamp_id;
    private int application_state_id;
}
