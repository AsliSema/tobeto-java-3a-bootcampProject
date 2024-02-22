package com.tobeto.bootcampProject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcamps;
}
