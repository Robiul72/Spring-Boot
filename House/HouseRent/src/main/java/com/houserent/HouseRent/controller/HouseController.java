package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.OwnerEntityModel;
import com.houserent.HouseRent.repository.IHouseRepo;
import com.houserent.HouseRent.service.HouseService;
import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private IHouseRepo houseRepo;

    @Autowired
    private OwnerService ownerService;

//    @RequestMapping("/houseview")
//    private String allHouse(Model m){
//        List<HouseRentModel> houseRentModelList=houseService.getAllHouse();
//
//        m.addAttribute("houseRentModelList", houseRentModelList);
//        m.addAttribute("title", "All House");
//
//        return "HouseView";
//
//    }

    //  House Rent Form start
    @GetMapping("/house/form")
    public String houseRentForm(Model m){
        List<OwnerEntityModel> ownerList=ownerService.getAllOwner();

        // to add department as dropdown from Department Model using Join Querry

        m.addAttribute("ownerEntityModel", new OwnerEntityModel());
        m.addAttribute("ownerList", ownerList);

        m.addAttribute("house", new HouseRentModel());
        m.addAttribute("title", "Add House");

        return "HouseFrom";
    }
    // House Rent form end


    //  House Rent view start
    @GetMapping("/house/view")
    public  String allHouseView( Model m){
        List<HouseRentModel> houseRentModelList=houseRepo.findAll();
        m.addAttribute("houseRentModelList", houseRentModelList);

//        m.addAttribute("house", new HouseRentModel());
//        m.addAttribute("title", "All House ");
        return "HouseView";
    }
    // House Rent form end


    // House Rent Save start
    @PostMapping("/house/save")
    public String saveHouse(@ModelAttribute HouseRentModel house) {
        houseService.saveHouse(house);
        return "redirect:/house/view";
    }
    // House Rent Save end





    // House Rent delete start
    @RequestMapping("/house/delete/{id}")
    public String deleteHouse(@PathVariable int id){
        houseService.deleteHouse(id);
        return "redirect:/house/view";
    }
    // House Rent delete end



    // House Rent Edit start
    @RequestMapping("/house/edit/{id}")
    public String editHouse(@PathVariable ("id") int id, Model m){
        HouseRentModel h=houseService.findById(id);
        m.addAttribute("houseedit", h);
        return "houseedit";
    }
    // House Rent Edit end

}
