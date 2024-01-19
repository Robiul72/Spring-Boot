package com.houserent.HouseRent.repository;


import com.houserent.HouseRent.model.OwnerEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepo extends JpaRepository <OwnerEntityModel, Integer> {
}
