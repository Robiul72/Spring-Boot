package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.OwnerModel;
import com.houserent.HouseRent.repository.IOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private IOwnerRepo ownerRepo;


    public List<OwnerModel> getAllOwner(){

        return ownerRepo.findAll();
    }

    public void ownerSave(OwnerModel ownerModel){

        ownerRepo.save(ownerModel);
    }

    public List<OwnerModel> getAllStuCustomer(){
        return ownerRepo.findAll();
    }

    public  void deleteOwner(int id){
        ownerRepo.deleteById(id);
    }

    public Optional<OwnerModel> findById(int id){

        return  ownerRepo.findById(id);
    }

}
