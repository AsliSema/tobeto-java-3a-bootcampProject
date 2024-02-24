package com.tobeto.bootcampProject.entities;

import com.tobeto.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcampState")
public class BootcampState extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "bootcampState")
    private List<Bootcamp> bootcamps;
}
