package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.CustomerFrom;
import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseRentService {

    @Autowired
    private IHouseRentRepo houseRentRepo;


    public void saveHouseRent(HouseRentModel houseRentModel){

        houseRentRepo.save(houseRentModel);
    }

    public List<HouseRentModel> getAllStuCustomer(){
        return houseRentRepo.findAll();
    }

    public  void deleteHouseRent(int id){
        houseRentRepo.deleteById(id);
    }

    public HouseRentModel findById(int id){

        return  houseRentRepo.findById(id).get();
    }

}
