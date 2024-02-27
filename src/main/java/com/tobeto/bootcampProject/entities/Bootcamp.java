package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Bootcamp")
@EqualsAndHashCode(callSuper = true)
public class Bootcamp extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private  LocalDateTime endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bootcampState_id")
    private BootcampState bootcampState;

    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;


}
