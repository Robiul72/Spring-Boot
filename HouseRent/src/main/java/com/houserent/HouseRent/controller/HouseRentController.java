package com.houserent.HouseRent.controller;


import com.houserent.HouseRent.model.CustomerFrom;
import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.ICustomerRepo;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import com.houserent.HouseRent.service.CustomerService;
import com.houserent.HouseRent.service.HouseRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HouseRentController {


    @Autowired
    IHouseRentRepo houseRentRepo;
    @Autowired
    HouseRentService houseRentService;



    //  House Rent Form start
    @GetMapping("/houserentform")
    public String houseRentForm(Model m){
        m.addAttribute("houserent", new HouseRentModel());
        return "houseRentFrom";
    }
    // House Rent form end


    // House Rent Save start
    @PostMapping("/houserent/save")
    public String saveHouseRent(@ModelAttribute("houserent") HouseRentModel houserent) {
        houseRentService.saveHouseRent(houserent);
        return "redirect:/houserent/view";
    }
    // House Rent Save end


    //  House Rent view start
    @GetMapping("/houserent/view")
    public  String customerView( Model m){
        List<HouseRentModel> houseRentModelList=houseRentRepo.findAll();
        m.addAttribute("houseRentModelList", houseRentModelList);
        return  "houseRentView";
    }
    // House Rent form end






    // House Rent delete start
    @RequestMapping("/houserent/delete/{id}")
    public String deleteHouseRent(@PathVariable int id){
        houseRentService.deleteHouseRent(id);
        return "redirect:/houserent/view";
    }
    // House Rent delete end



    // House Rent Edit start
    @RequestMapping("/houserent/edit/{id}")
    public String editHouseRent(@PathVariable ("id") int id, Model m){
        Optional<HouseRentModel> h=houseRentService.findById(id);
        m.addAttribute("houserentedit", h);
        return "houserentedit";
    }
    // House Rent Edit end




//    @RequestMapping("/houserent/details/{id}")
//    public String houseDetails(@PathVariable("id") int id, Model m){
//
//       HouseRentModel house=houseRentService.findById(id);
//        m.addAttribute("housedetails", house);
//
//        return "houseDetails";
//    }

    @RequestMapping("/houserent/details/{id}")
    public String houseDetails(@PathVariable("id") int id, Model m){

        Optional<HouseRentModel> house=houseRentService.findById(id);
        m.addAttribute("housedetails", house);

        return "houseDetails";
    }

}
