package com.houserent.HouseRent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerFrom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cus_Name;

    @Column(unique = true, nullable = false)
    private String cus_Email;

    private String cus_Mobile;
    private String cus_Gender;
    private String cus_Address;
    private String cus_Date;


}
