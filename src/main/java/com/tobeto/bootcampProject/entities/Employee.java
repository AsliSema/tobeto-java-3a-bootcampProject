package com.tobeto.bootcampProject.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@EqualsAndHashCode(callSuper = true)
public class Employee extends User{

    @Column(name = "position")
    private String position;
}
