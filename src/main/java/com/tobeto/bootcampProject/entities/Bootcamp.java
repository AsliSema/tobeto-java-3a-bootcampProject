package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Bootcamp")
public class Bootcamp extends BaseEntity <Integer> {

    @Column(name="name")
    private String name;

    /*
    @Column(name="instructor_id")
    private int instructor_id;

    @Column(name="bootcamp_state_id")
    private int bootcampState_id;
     */

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private  LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "bootcampState_id")
    private BootcampState bootcampState;


}
