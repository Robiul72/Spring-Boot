package com.houserent.HouseRent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnerEntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String h_Rent_NID;
    private String h_Rent_Owner_Name;

    private String h_Rent_Date;

    @Column(unique = true, nullable = false)
    private String h_Rent_Email;

    private String h_Rent_Mobile;

    private String image;





}
