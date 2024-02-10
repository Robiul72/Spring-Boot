package com.houserent.HouseRent.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "owner_list")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class OwnerModel {

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

    private String h_Date;



//
//    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<HouseRentModel> houses;
//
//    // Getter and setter for houses
//
//    public List<HouseRentModel> getHouses() {
//        return houses;
//    }
//
//    public void setHouses(List<HouseRentModel> houses) {
//        this.houses = houses;
//    }


//    public List<HouseRentModel> getHouses() {
//        return houses;
//    }
//
//    public void setHouses(List<HouseRentModel> houses) {
//        this.houses = houses;
//    }

}
