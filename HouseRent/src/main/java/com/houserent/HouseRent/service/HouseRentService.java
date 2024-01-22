package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseRentService {

    @Autowired
    private IHouseRentRepo houseRentRepo;


    public List<HouseRentModel> getAllOwner(){

        return houseRentRepo.findAll();
    }


    public void saveHouseRent(HouseRentModel houseRentModel){

        houseRentRepo.save(houseRentModel);
    }

    public List<HouseRentModel> getAllStuCustomer(){
        return houseRentRepo.findAll();
    }

    public  void deleteHouseRent(long id){
        houseRentRepo.deleteById(id);
    }
    public HouseRentModel findByIdHouse(long id) {
        return  houseRentRepo.findById(id).get();
    }

    public Optional<HouseRentModel> findById(long id){
        return  houseRentRepo.findById(id);
    }

    public List <HouseRentModel> houseList (){
        List <HouseRentModel> houseList= houseRentRepo.findAll();
        return houseList;
    }

//    public  List<HouseRentModel> userHomeLocation(String location, String bedroom){
//        List<HouseRentModel> houseList=houseRentRepo.findAll();
//
//        return houseList;
//    }


}
