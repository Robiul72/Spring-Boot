package com.GM.GarmentsManagement.employeeEntity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long em_id;
    @Column
    private String em_name;

    @Column
    private String em_nid;
    @Column
    private String em_phone;
    @Column
    private String em_gender;

    @Column
    private String em_dob;


    @Column
    private String em_PreviousCompany;

    @Column
    private String em_profileImg;

    @Column
    private String em_joiningDate;

    @Column
    private String em_presentAddress;

    @Column
    private String em_permanentAddress;

    @Column
    private String em_email;

    @Column
    private String em_password;




}
