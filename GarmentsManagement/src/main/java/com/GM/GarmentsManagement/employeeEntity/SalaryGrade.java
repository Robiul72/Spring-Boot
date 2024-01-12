package com.GM.GarmentsManagement.employeeEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "saleygrade")
public class SalaryGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salary_id;

    private String salary_name;
    private long basicSalary;
    private long totalSalary;
    private long houseRant;
    private long healthRant;


    public SalaryGrade(Long salary_id) {
        this.salary_id = salary_id;
    }


}
