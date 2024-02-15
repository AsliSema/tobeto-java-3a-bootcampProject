package com.tobeto.bootcampProject.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="applicants")
@EqualsAndHashCode(callSuper = true)
public class Applicant extends User{

    private String about;
}
