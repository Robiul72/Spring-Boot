package com.houserent.HouseRent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HouseRentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String h_Rent_Area;
    private String h_Rent_Owner_Name;

    private String h_Rent_Name;
    private String h_Rent_Category;
    private String h_Rent_Bedroom;
    private String h_Rent_Price;

    @Column(unique = true, nullable = false)
    private String h_Rent_Email;

    private String h_Rent_Mobile;
    private String h_Rent_Address;
    private String h_Rent_Description;

//    private String h_Rent_Image;


}
