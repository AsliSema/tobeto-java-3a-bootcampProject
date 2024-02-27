package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Blacklist")
public class Blacklist extends BaseEntity<Integer> {

    @Column(name="reason")
    private String reason;

    @Column(name="date")
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name="applicant_id")
    private Applicant applicant;
}
