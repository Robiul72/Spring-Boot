package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DetailsController {

    @Autowired
    OwnerService houseRentService;

//    @RequestMapping("/houserent/details/{id}")
//    public String profilestudent(@PathVariable("id") int id, Model m){
//
//        Optional<HouseRentModel> house=houseRentService.findById(id);
//
//        m.addAttribute("houserentdetails", house);
//
//        return "detailsPage";
//    }


//    @RequestMapping("/houserent/details/{id}")
//    public String profilestudent(@PathVariable("id") int id, Model m){
//        Optional<HouseRentModel> house = houseRentService.findById(id);
//
//        m.addAttribute("houserentdetails", house);
//            return "houseNotFoundPage";
//
//    }
}
