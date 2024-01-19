package com.houserent.HouseRent.repository;

import com.houserent.HouseRent.model.HouseRentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHouseRepo extends JpaRepository <HouseRentModel, Integer> {
}
