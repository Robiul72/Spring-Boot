package com.houserent.HouseRent.controller;


import com.houserent.HouseRent.model.OwnerEntityModel;
import com.houserent.HouseRent.repository.IOwnerRepo;
import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class OwnerController {


    @Autowired
    IOwnerRepo houseRentRepo;
    @Autowired
    OwnerService houseRentService;





    //  House Rent Form start
    @GetMapping("/ownerform")
    public String houseRentForm(Model m){
        m.addAttribute("houserent", new OwnerEntityModel());
        return "OwnerFrom";
    }
    // House Rent form end

    // Image Create start

    public ResponseEntity<byte[] > displayImage(@RequestParam ("id") int id) throws IOException {
        Optional<OwnerEntityModel> ownerEntityModel=houseRentRepo.findById(id);
        if(ownerEntityModel.isPresent()){
            OwnerEntityModel owner = ownerEntityModel.get();

            String uploadDirectory = "src/main/resources/static/assets/images/user/";
            String fileName = owner.getImage();
            String filePath = Paths.get(uploadDirectory, fileName).toString();

            try{
                Path path = Paths.get(filePath);
                byte[] imageBytes = Files.readAllBytes(path);

                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline filename=" + path.getFileName().toString())
                        .body(imageBytes);
            } catch (IOException e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Image Create end


    // House Rent Save start
    @PostMapping("/owner/save")
    public String saveHouseRent(@ModelAttribute("houserent") OwnerEntityModel houserent) {
        houseRentService.saveHouseRent(houserent);
        return "redirect:/owner/view";
    }
    // House Rent Save end



    //  House Rent view start
    @GetMapping("/owner/view")
    public  String customerView( Model m){
        List<OwnerEntityModel> houseRentModelList=houseRentRepo.findAll();
        m.addAttribute("houseRentModelList", houseRentModelList);
        return "OwnerView";
    }
    // House Rent form end






    // House Rent delete start
    @RequestMapping("/owner/delete/{id}")
    public String deleteHouseRent(@PathVariable int id){
        houseRentService.deleteHouseRent(id);
        return "redirect:/owner/view";
    }
    // House Rent delete end



    // House Rent Edit start
    @RequestMapping("/owner/edit/{id}")
    public String editHouseRent(@PathVariable ("id") int id, Model m){
        Optional<OwnerEntityModel> h=houseRentService.findById(id);
        m.addAttribute("houserentedit", h);
        return "owneredit";
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

        Optional<OwnerEntityModel> house=houseRentService.findById(id);
        m.addAttribute("housedetails", house);

        return "houseDetails";
    }

}
