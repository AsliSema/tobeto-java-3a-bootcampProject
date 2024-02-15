package com.tobeto.bootcampProject.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instructors")
@EqualsAndHashCode(callSuper = true)
public class Instructor extends User{
    private String companyName;
}
