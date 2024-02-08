package com.houserent.HouseRent.controller;


import com.houserent.HouseRent.model.CustomerFrom;
import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.OwnerModel;
import com.houserent.HouseRent.repository.ICustomerRepo;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import com.houserent.HouseRent.service.CustomerService;
import com.houserent.HouseRent.service.HouseRentService;
import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/admin")
public class HouseRentController {
    @Autowired
    IHouseRentRepo houseRentRepo;
    @Autowired
    HouseRentService houseRentService;
    @Autowired
    private OwnerService ownerService;

    //  House Rent Form start
    @GetMapping("/houserentform")
    public String buildForm(Model m){
        List<OwnerModel> ownerList=ownerService.getAllOwner();
        m.addAttribute("ownerList", ownerList);
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("ownerEntityModel", new OwnerModel());
        m.addAttribute("houserent", new HouseRentModel());
        m.addAttribute("title", "Add Building");
        return "houseRentFrom";
    }
    // House Rent form end


    // Image Create start
    @RequestMapping("/house/display")
    public ResponseEntity<byte[] > displayImage(@RequestParam ("id") long id) throws IOException {
        Optional<HouseRentModel> houseOptional=houseRentRepo.findById(id);
        if(houseOptional.isPresent()){
            HouseRentModel owner = houseOptional.get();
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

    @PostMapping("/house/save")
    public String save(@ModelAttribute @Validated HouseRentModel houseRent, BindingResult result, @RequestParam("image") MultipartFile image) throws IOException, SQLException {
        //       Start Image
        if (!image.isEmpty()) {
            byte[] bytes = image.getBytes();
            String originalFilename = image.getOriginalFilename();
            // Generate a timestamp to make the filename unique
            long timestamp = System.currentTimeMillis();
            // Extract file extension from the original filename
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // Create a new unique filename using timestamp
            String newFileName = "owner_image_" + timestamp + fileExtension;
            houseRent.setImage(newFileName);
            // Save the image to the specified directory
            String uploadDirectory = "src/main/resources/static/assets/images/user/";
            Path uploadPath = Paths.get(uploadDirectory);
            // Create the directory if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(newFileName);
            Files.write(filePath, bytes);
        }
        houseRentService.saveHouseRent(houseRent);
        return "redirect:/houserent/view";
    }
    // Image Create end


    // House Rent Save start
//    @PostMapping("/houserent/saves")
//    public String saveHouseRent(@ModelAttribute("houserent") HouseRentModel houserent) {
//        houseRentService.saveHouseRent(houserent);
//        return "redirect:/houserent/view";
//    }
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
        List<OwnerModel> ownerList=ownerService.getAllOwner();
        m.addAttribute("ownerList", ownerList);
        m.addAttribute("ownerEntityModel", new OwnerModel());
        Optional<HouseRentModel> h=houseRentService.findById(id);
        m.addAttribute("houserentedit", h);
        return "houserentedit";
    }
    // House Rent Edit end


    @RequestMapping("/building/details/{id}")
    public String houseDetails(@PathVariable("id") int id, Model m){
        Optional<HouseRentModel> house=houseRentService.findById(id);
        m.addAttribute("housedetails", house);
        return "BuildingDetails";
    }


//    @RequestMapping("/contact/details/{id}")
//    public String contactDetails(@PathVariable("id") int id, Model m){
//        Optional<OwnerModel> owner=ownerService.findById(id);
//        m.addAttribute("contactdetails", owner);
//        return "ownerContact";
//    }


//    @RequestMapping("/houseLocationAndBedroomSearch")
//    public String  houseSearch (Model model, String location, String bedroom){
//        List<HouseRentModel> houseList = houseRentRepo.findByBedroomAndLocation(bedroom,location);
//        model.addAttribute("userjobdatas",houseList);
//
//        return "BuildingHome";
//    }

    @RequestMapping("/houseLocationAndBedroomSearch")
    public String  houseSearch (Model model, String location){
        List<HouseRentModel> houseList = houseRentRepo.findByLocation(location);
        model.addAttribute("userjobdatas",houseList);

        return "BuildingHome";
    }

    @RequestMapping("/singleHouseView")
    public String  userHomeView (Model model){
        List<HouseRentModel> houseList = houseRentService.houseList();
        model.addAttribute("userjobdatas",houseList);

        return "BuildingHome";
    }

//    @GetMapping("/buildinghome")
//    public String houseView(Model m){
//        List<HouseRentModel> houseRentModelList=houseRentRepo.findAll();
//        m.addAttribute("houseRentModelList", houseRentModelList);
//        return "BuildingHome";
//    }

    @GetMapping("/successful")
    public String successPage(){

        return  "successPage";
    }


    @GetMapping("/house-rent-report")
    public String generateReport(Model model) {
        List<HouseRentModel> houseRents = houseRentService.getAllHouseRents();
        int totalHouses = houseRents.size();

        model.addAttribute("houseRents", houseRents);
        model.addAttribute("totalHouses", totalHouses);

        return "index";
    }


}
