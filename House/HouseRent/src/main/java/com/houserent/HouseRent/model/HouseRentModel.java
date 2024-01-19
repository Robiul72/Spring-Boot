package com.houserent.HouseRent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "housetable")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HouseRentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String house_Owner;

    private String house_Category;
    private String house_Bedroom;
    private String house_Price;
    private String house_Description;

    private String house_Gender;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private OwnerEntityModel ownerName;





}
