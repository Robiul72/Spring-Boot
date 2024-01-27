package com.houserent.HouseRent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "owner_list")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String h_Rent_NID;
    private String h_Rent_Owner_Name;

    private String h_Rent_Date;

    @Column(unique = true, nullable = false)
    private String h_Rent_Email;

    private String password;

    private String role;

    private String h_Rent_Mobile;

    private String image;

    private String h_Date;


@ManyToMany(
        fetch = FetchType.EAGER
)

    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<RoleModel> roleModels= new HashSet<>();
    public OwnerModel(String h_Rent_Email, String password) {

        this.h_Rent_Email = h_Rent_Email;
        this.password = password;
    }

  public  void addRole(RoleModel roleModel){
        this.roleModels.add(roleModel);
  }
}
