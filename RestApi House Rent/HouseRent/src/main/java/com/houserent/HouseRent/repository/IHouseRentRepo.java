package com.houserent.HouseRent.repository;


import com.houserent.HouseRent.model.HouseRentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHouseRentRepo extends JpaRepository<HouseRentModel, Integer> {

//    List<HouseRentModel> findByBedroomAndLocation(String bedroom, String location);

    List<HouseRentModel> findByLocation(String location);



//        List<HouseRentModel> findByOwner_Id(int ownerId);
//"SELECT s from  Style s join RawMaterial raw on raw.styleId.id= s.id where s.id=:id"
//    @Query("select h from house_list h join owner_list o on h.ownerName.id= o.id ")
//        List<HouseRentModel> findByOwner_Name(int owner);

    boolean existsById(Integer id);

    void updateHouseRent(Integer id, HouseRentModel updatedHouse);

}
