package com.houserent.HouseRent.repository;

import com.houserent.HouseRent.model.OwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepo extends JpaRepository<OwnerModel, Integer> {
}
