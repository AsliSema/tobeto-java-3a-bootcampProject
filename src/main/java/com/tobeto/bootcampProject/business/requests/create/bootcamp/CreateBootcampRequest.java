package com.tobeto.bootcampProject.business.requests.create.bootcamp;

import com.tobeto.bootcampProject.entities.BootcampState;
import com.tobeto.bootcampProject.entities.Instructor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    private String name;
    private int instructorId;
    private LocalDateTime startDate;
    private  LocalDateTime endDate;
    private int bootcampStateId;
}
