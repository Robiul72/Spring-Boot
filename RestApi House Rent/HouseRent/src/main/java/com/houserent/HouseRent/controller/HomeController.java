package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.CustomerFrom;
import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.OwnerModel;
import com.houserent.HouseRent.service.CustomerService;
import com.houserent.HouseRent.service.HouseRentService;
import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {


    @Autowired
    private HouseRentService houseRentService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private CustomerService customerService;


    @GetMapping("/")
    public String home(){
        return "BuildingHome";
    }


    @GetMapping("/admin")
    public String houseReport(Model model){
        List<HouseRentModel> houseRents = houseRentService.getAllHouseRents();
        int totalHouses = houseRents.size();
        model.addAttribute("houseRents", houseRents);
        model.addAttribute("totalHouses", totalHouses);


        List<OwnerModel> owners =ownerService.getAllOwner();
        int totalOwners = owners.size();
        model.addAttribute("owners", owners);
        model.addAttribute("totalOwners", totalOwners);



        List<CustomerFrom> customers=customerService.getAllCustomer();
        int totalCustomers = customers.size();
        model.addAttribute("customers", customers);
        model.addAttribute("totalCustomers", totalCustomers);

        return "index";
    }



    @GetMapping("/login")
    public String login(){

        return "login";
    }



}
