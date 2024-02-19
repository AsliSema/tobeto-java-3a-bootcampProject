package com.tobeto.bootcampProject.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@PrimaryKeyJoinColumn(name = "id")

public class Instructor extends User{

    @Column(name = "companyName")
    private String companyName;
}
