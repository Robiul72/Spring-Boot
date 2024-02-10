package com.houserent.HouseRent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "house_list")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HouseRentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String build_Name;
    private String owner_Name;
    private String floor_No;
    private String unit_No;
    private String bedroom;
    private String location;
    private String description;

    private String monthly_rent;
    private String electricity_rent;
    private String water_rent;
    private String garbage_rent;
    private String total_cost;
    private String total_Advance;
    private String total_Due;
    private String due_Pay;

    private String image;

    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }



    @ManyToOne
    @JoinColumn(name="owner_id")
    OwnerModel ownerName;



}
