package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.OwnerModel;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import com.houserent.HouseRent.repository.IOwnerRepo;
import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller

public class HomeController {

    @Autowired
    IHouseRentRepo houseRentRepo;

    @Autowired
    IOwnerRepo ownerRepo;

    @Autowired
    OwnerService ownerService;



    @GetMapping("/home")
    public String houseView(Model m){
        List<HouseRentModel> houseRentModelList=houseRentRepo.findAll();
        m.addAttribute("houseRentModelList", houseRentModelList);
        return "home";
    }

    @GetMapping("/ownercontact")
    public String ownerContact(Model m){
        List<OwnerModel> ownerModels=ownerRepo.findAll();
        m.addAttribute("ownerModels", ownerModels);

        return "ownerContact";

    }



}
