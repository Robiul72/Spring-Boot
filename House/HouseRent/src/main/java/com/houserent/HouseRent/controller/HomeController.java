package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.OwnerEntityModel;
import com.houserent.HouseRent.repository.IOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {

    @Autowired
    IOwnerRepo houseRentRepo;




    @GetMapping("/home")
    public String houseView(Model m){
        List<OwnerEntityModel> houseRentModelList=houseRentRepo.findAll();
        m.addAttribute("houseRentModelList", houseRentModelList);
        return "home";
    }


}
