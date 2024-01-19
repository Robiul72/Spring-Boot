package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.ListOfBuilding;
import com.houserent.HouseRent.model.OwnerEntityModel;
import com.houserent.HouseRent.repository.IListOfBuildingRepo;
import com.houserent.HouseRent.service.ListOfBuildService;
import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListOfBuildController {

    @Autowired
    private ListOfBuildService listOfBuildService;

    @Autowired
    private IListOfBuildingRepo listOfBuildingRepo;

    @Autowired
    private OwnerService ownerService;


    //  House Rent Form start
    @GetMapping("/build/form")
    public String buildForm(Model m){
        List<OwnerEntityModel> ownerList=ownerService.getAllOwner();

        // to add department as dropdown from Department Model using Join Querry

        m.addAttribute("ownerEntityModel", new OwnerEntityModel());
        m.addAttribute("ownerList", ownerList);

        m.addAttribute("build", new ListOfBuilding());
        m.addAttribute("title", "Add Building");

        return "ListBuildFrom";
    }
    // House Rent form end


    //  House Rent view start
    @GetMapping("/build/view")
    public  String allBuildView( Model m){
        List<ListOfBuilding> listOfBuildingList=listOfBuildingRepo.findAll();
        m.addAttribute("listOfBuildingList", listOfBuildingList);

//        m.addAttribute("house", new HouseRentModel());
//        m.addAttribute("title", "All House ");
        return "ListBuildView";
    }
    // House Rent form end


    // House Rent Save start
    @PostMapping("/build/save")
    public String saveBuild(@ModelAttribute ListOfBuilding build) {
        listOfBuildService.saveBuild(build);
        return "redirect:/build/view";
    }
    // House Rent Save end





    // House Rent delete start
    @RequestMapping("/build/delete/{id}")
    public String deleteBuild(@PathVariable int id){
        listOfBuildService.deleteBuild(id);
        return "redirect:/build/view";
    }
    // House Rent delete end



    // House Rent Edit start
//    @RequestMapping("/build/edit/{id}")
//    public String editBuild(@PathVariable ("id") int id, Model m){
//        ListOfBuilding h=listOfBuildService.findById(id);
//        m.addAttribute("build", h);
//        return "build";
//    }

    @RequestMapping("/build/edit/{id}")
    public String editBuild(@PathVariable ("id") int id, Model m){

        ListOfBuilding b=listOfBuildService.findById(id);
        m.addAttribute("buildedit", b);
        return "buildedit";
    }
    // House Rent Edit end

}
