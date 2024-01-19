package com.houserent.HouseRent.repository;


import com.houserent.HouseRent.model.ListOfBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IListOfBuildingRepo extends JpaRepository<ListOfBuilding, Integer> {
}
