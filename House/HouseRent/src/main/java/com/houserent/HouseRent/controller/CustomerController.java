package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.CustomerFrom;
import com.houserent.HouseRent.repository.ICustomerRepo;
import com.houserent.HouseRent.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerRepo customerRepo;
    @Autowired
    CustomerService customerService;



    //  Customer Form start
    @GetMapping("/customerform")
    public String customer(Model m){
        m.addAttribute("customer", new CustomerFrom());
        return "customerFrom";
    }
    // Customer form end


 //  Customer view start
    @GetMapping("/customer/view")
    public  String customerView( Model m){
        List<CustomerFrom> customerList=customerRepo.findAll();
        m.addAttribute("customerList", customerList);
        return  "customerView";
    }
    // Customer form end


    // Customer Save start
    @PostMapping("/customer/save")
    public String saveCustomer(@ModelAttribute CustomerFrom c) {
        customerService.saveCustomer(c);
        return "redirect:/customer/view";
    }
    // Customer Save end



    // Customer delete start
    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/view";
    }
    // Customer delete end



    // Customer Edit start
    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable ("id") int id, Model m){
        CustomerFrom c=customerService.findById(id);
        m.addAttribute("customeredit", c);
        return "customeredit";
    }
    // Customer Edit end


}
