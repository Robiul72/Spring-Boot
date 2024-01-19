package com.houserent.HouseRent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "building_List")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListOfBuilding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String build_Name;
    private String owner_Name;
    private String floor_No;
    private String unit_No;
    private String bedroom;
    private String location;

    private String monthly_rent;
    private String electricity_rent;
    private String water_rent;
    private String garbage_rent;
    private String description;
    private String total_cost;



    @ManyToOne
    @JoinColumn(name="owner_id")
    private OwnerEntityModel ownerName;

}
