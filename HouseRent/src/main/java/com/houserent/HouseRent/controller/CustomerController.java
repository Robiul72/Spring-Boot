package com.houserent.HouseRent.controller;

import com.houserent.HouseRent.model.CustomerFrom;
import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.ICustomerRepo;
import com.houserent.HouseRent.service.CustomerService;
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


    // Image Create start
    @RequestMapping("/customer/display")
    public ResponseEntity<byte[] > displayImage(@RequestParam ("id") long id) throws IOException {
        Optional<CustomerFrom> customerOptional=customerRepo.findById((int) id);
        if(customerOptional.isPresent()){
            CustomerFrom owner = customerOptional.get();
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

    @PostMapping("/customer/save")
    public String save(@ModelAttribute @Validated CustomerFrom customer, BindingResult result, @RequestParam("image") MultipartFile image) throws IOException, SQLException {
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
            customer.setImage(newFileName);
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
        customerService.saveCustomer(customer);
        return "redirect:/singleHouseView";
    }
    // Image Create end


 //  Customer view start
    @GetMapping("/customer/view")
    public  String customerView( Model m){
        List<CustomerFrom> customerList=customerRepo.findAll();
        m.addAttribute("customerList", customerList);
        return  "customerView";
    }
    // Customer form end


    // Customer Save start
    @PostMapping("/customer/saves")
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



    @GetMapping("/customer-rent-report")
    public String generateReportcustomer(Model model) {
        List<CustomerFrom> customers = customerService.getAllCustomer();
<<<<<<< HEAD
        int totalcustomer = customers.size();

        model.addAttribute("customers", customers);
        model.addAttribute("totalcustomer", totalcustomer);
=======
        int totalcustomers = customers.size();

        model.addAttribute("customers", customers);
        model.addAttribute("totalcustomers", totalcustomers);
>>>>>>> 0feac06c7d881a01c80ed618e36c274ca4031ede

        return "index";
    }





}
