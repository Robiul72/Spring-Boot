package com.GM.GarmentsManagement.employeeEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  long designation_id;
    private String designation_title;


    @ManyToOne
    @JoinColumn(name="department_id")
    Department department;

    @ManyToOne
    @JoinColumn(name= "salary_id")
    SalaryGrade salaryGrade;
}
