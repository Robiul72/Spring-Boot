package com.ClassExam.CRUD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="students")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;
    private int roll;
    private String name;

    @Column(unique = true, nullable = false, name = "email")
    private String mail;

    private String subject;

}
