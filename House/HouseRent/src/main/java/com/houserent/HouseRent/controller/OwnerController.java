package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.OwnerModel;
import com.houserent.HouseRent.model.RoleModel;
import com.houserent.HouseRent.repository.IOwnerRepo;
import com.houserent.HouseRent.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
//@RequestMapping("/owner")
public class OwnerController {


    @Autowired
    IOwnerRepo ownerRepo;

    @Autowired
    OwnerService ownerService;

    //  House Rent Form start
    @GetMapping("/owner/ownerform")
    public String ownerForm(Model m){
        m.addAttribute("owner", new OwnerModel());
        return "OwnerFrom";
    }
    // House Rent form end

    // Image Create start
    @RequestMapping("/owner/owner/display")
    public ResponseEntity<byte[] > displayImage(@RequestParam ("id") int id) throws IOException {
        Optional<OwnerModel> ownerOptional=ownerRepo.findById(id);
        if(ownerOptional.isPresent()){
            OwnerModel owner = ownerOptional.get();
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

    @PostMapping("/owner/save")
    public String save(@ModelAttribute @Validated OwnerModel owner, BindingResult result, @RequestParam("image") MultipartFile image) throws IOException, SQLException {
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
            owner.setImage(newFileName);
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


        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        owner.setPassword(encoder.encode(owner.getPassword()));
        RoleModel userRole=new RoleModel(1 );
        owner.addRole(userRole);

        ownerService.ownerSave(owner);
        return "redirect:/owner/view";
    }
    // Image Create end

    //  House Rent view start
    @GetMapping("/owner/view")
    public  String ownerView( Model m){
        List<OwnerModel> ownerModelList=ownerRepo.findAll();
        m.addAttribute("ownerModelList", ownerModelList);
        return "OwnerView";
    }
    // House Rent form end


    // House Rent Save start
    @PostMapping("/owner/saves")
    public String saveHouseRent(@ModelAttribute("owner")  OwnerModel ownerModel) {
        ownerService.ownerSave(ownerModel);
        return "redirect:/owner/view";
    }
    // House Rent Save end





    // House Rent delete start
    @RequestMapping("/owner/delete/{id}")
    public String deleteOwner(@PathVariable int id){
        ownerService.deleteOwner(id);
        return "redirect:/owner/view";
    }

//    @RequestMapping("/houserent/delete/{id}")
//    public String deleteHouseRent(@PathVariable int id){
//        houseRentService.deleteHouseRent(id);
//        return "redirect:/houserent/view";
//    }
    // House Rent delete end



    // House Rent Edit start
    @RequestMapping("/owner/edit/{id}")
    public String editOwner(@PathVariable ("id") int id, Model m){
        Optional<OwnerModel> ownerModelList=ownerService.findById(id);
        m.addAttribute("ownerModelList", ownerModelList);
        return "OwnerEdit";
    }
    // House Rent Edit end



    @GetMapping("/owner-rent-report")
    public String generateReport(Model model) {
        List<OwnerModel> owners = ownerService.getAllOwner();
        int totalOwners = owners.size();

        model.addAttribute("owners", owners);
        model.addAttribute("totalOwners", totalOwners);

        return "index";
    }

}

