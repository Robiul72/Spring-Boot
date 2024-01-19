package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.IHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    private IHouseRepo houseRepo;


    public void saveHouse(HouseRentModel h){
        houseRepo.save(h);
    }


    public List<HouseRentModel> getAllHouse(){
        return houseRepo.findAll();
    }

    public  void deleteHouse(int id){

        houseRepo.deleteById(id);
    }

    public HouseRentModel findById(int id){

        return  houseRepo.findById(id).get();
    }

}
