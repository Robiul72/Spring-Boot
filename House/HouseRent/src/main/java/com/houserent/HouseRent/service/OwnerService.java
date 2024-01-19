package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.OwnerEntityModel;
import com.houserent.HouseRent.repository.IOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private IOwnerRepo houseRentRepo;


    public List<OwnerEntityModel> getAllOwner(){

        return houseRentRepo.findAll();
    }

    public void saveHouseRent(OwnerEntityModel houseRentModel){

        houseRentRepo.save(houseRentModel);
    }

    public List<OwnerEntityModel> getAllStuCustomer(){
        return houseRentRepo.findAll();
    }

    public  void deleteHouseRent(int id){
        houseRentRepo.deleteById(id);
    }

    public Optional<OwnerEntityModel> findById(int id){

        return  houseRentRepo.findById(id);
    }

}
