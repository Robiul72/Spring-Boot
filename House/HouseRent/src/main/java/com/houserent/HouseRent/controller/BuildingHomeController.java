package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BuildingHomeController {

    @Autowired
    IHouseRentRepo houseRentRepo;

//    @GetMapping("/buildinghome")
//    public String houseView(Model m){
//        List<HouseRentModel> houseRentModelList=houseRentRepo.findAll();
//        m.addAttribute("houseRentModelList", houseRentModelList);
//        return "BuildingHome";
//    }

//    @RequestMapping("/userhomesearch")
//    public String userHomeView(Model m, String location, String bedroom ){
//        List<HouseRentModel> houseList=houseRentRepo.findBylocationAndbedroom(location, bedroom);
//        m.addAttribute("houseRentModelList", houseList);
//        return "BuildingHome";
//    }
}
