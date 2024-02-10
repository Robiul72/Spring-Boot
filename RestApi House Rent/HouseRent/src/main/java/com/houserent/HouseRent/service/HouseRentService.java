package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HouseRentService  {

    @Autowired
    private IHouseRentRepo houseRentRepo;

//    public HouseRentModel updateHouseRent(Integer id, HouseRentModel houseRentModel){
//        HouseRentModel existing = IHouseRentRepo.findById(id)
//
//                .orElseThrow(() -> new EntityNotFoundException("House Rent is Updated " + id));
//
//        existing.setBuild_Name(houseRentModel.getBuild_Name());
//        existing.setOwner_Name(houseRentModel.getOwner_Name());
//        existing.setFloor_No(houseRentModel.getFloor_No());
//        existing.setBedroom(houseRentModel.getBedroom());
//        existing.setMonthly_rent(houseRentModel.getMonthly_rent());
//        existing.setWater_rent(houseRentModel.getWater_rent());
//
//        return houseRentRepo.save(existing);
//    }

private static List<HouseRentModel> list=new ArrayList<>();

    public void updateHouseRent(HouseRentModel houseRentModel, int id){

   list= list.stream().map(h->{
        if(h.getId()==id){
            h.setBedroom(houseRentModel.getBedroom());
            h.setBuild_Name(houseRentModel.getBuild_Name());
        }
    return h;
    }).collect(Collectors.toList());
    }




    public List<HouseRentModel> getAllOwner(){

        return houseRentRepo.findAll();
    }


    public void saveHouseRent(HouseRentModel houseRentModel){

        houseRentRepo.save(houseRentModel);
    }

    public List<HouseRentModel> getAllStuCustomer(){
        return houseRentRepo.findAll();
    }

    public  void deleteHouseRent(int id){
        houseRentRepo.deleteById(id);
    }

//    public HouseRentModel findByIdHouse(int id) {
//        return  houseRentRepo.findById(id).get();
//    }

    public Optional<HouseRentModel> findById(int id){
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
public List<HouseRentModel> getAllHouseRents() {
    return houseRentRepo.findAll();
}

    public void updateHouseRent(Optional<HouseRentModel> exiting) {
    }


}
