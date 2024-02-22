package com.tobeto.bootcampProject.business.requests.update.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
    private String name;
    private int instructor_id;
    private LocalDateTime startDate;
    private  LocalDateTime endDate;
    private int bootcampState_id;
}
