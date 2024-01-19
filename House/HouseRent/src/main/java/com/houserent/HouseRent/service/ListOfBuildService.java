package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.ListOfBuilding;
import com.houserent.HouseRent.repository.IListOfBuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListOfBuildService {

    @Autowired
    private IListOfBuildingRepo listOfBuilding;


    public void saveBuild(ListOfBuilding b){
        listOfBuilding.save(b);
    }


    public List<ListOfBuilding> getAllBuild(){
        return listOfBuilding.findAll();
    }

    public  void deleteBuild(int id){

        listOfBuilding.deleteById(id);
    }

    public ListOfBuilding findById(int id){

        return  listOfBuilding.findById(id).get();
    }
}
