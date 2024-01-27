package com.houserent.HouseRent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;

    private String description;


    public RoleModel(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel roleModel = (RoleModel) o;
        return id == roleModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public RoleModel(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
