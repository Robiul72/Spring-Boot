package com.houserent.HouseRent.repository;


import com.houserent.HouseRent.model.HouseRentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHouseRentRepo extends JpaRepository<HouseRentModel, Long> {

//    List<HouseRentModel> findByBedroomAndLocation(String bedroom, String location);

    List<HouseRentModel> findByLocation(String location);

}
