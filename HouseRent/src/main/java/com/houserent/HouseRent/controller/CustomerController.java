package com.houserent.HouseRent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    public String customer(){

        return "customerFrom";
    }

}
