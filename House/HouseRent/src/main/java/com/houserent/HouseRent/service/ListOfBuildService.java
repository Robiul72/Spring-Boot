//package com.houserent.HouseRent.service;
//
//import com.houserent.HouseRent.model.ListOfBuildingModel;
//import com.houserent.HouseRent.repository.IListOfBuildingRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ListOfBuildService {
//
//    @Autowired
//    private IListOfBuildingRepo listOfBuilding;
//
//
//    public void saveBuild(ListOfBuildingModel b){
//        listOfBuilding.save(b);
//    }
//
//
//    public List<ListOfBuildingModel> getAllBuild(){
//        return listOfBuilding.findAll();
//    }
//
//    public  void deleteBuild(int id){
//
//        listOfBuilding.deleteById(id);
//    }
//
//
//
//    public Optional<ListOfBuildingModel> findById(int id){
//
//        return  listOfBuilding.findById(id);
//    }
//}
