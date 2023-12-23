package com.example.FirstSpringBoot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int roll;
    @Column(length = 50)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String gender;
    private String hobby;
    private Date dob;

    @ManyToOne
    @JoinColumn(name="dpe_id")
    Department department;

}
