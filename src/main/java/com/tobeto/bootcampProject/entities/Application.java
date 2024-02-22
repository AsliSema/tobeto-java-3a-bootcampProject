package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="application")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
public class Application extends BaseEntity<Integer> {

    /*
    @Column(name="applicant_id")
    private int applicant_id;

    @Column(name="bootcamp_id")
    private int bootcamp_id;

    @Column(name="application_state_id")
    private int applicationState_id;
     */

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id", nullable = false)
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "bootcamp_id", referencedColumnName = "id", nullable = false)
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name = "application_state_id", referencedColumnName = "id", nullable = false)
    private ApplicationState applicationState;


}
