package com.houserent.HouseRent.restController;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.OwnerModel;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import com.houserent.HouseRent.repository.IOwnerRepo;
import com.houserent.HouseRent.service.HouseRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestHouseRentController {

    @Autowired
    private IHouseRentRepo houseRentRepo;


    // Get Api Owner Method Start
    @GetMapping("/house")
    public List<HouseRentModel> allHouseRentModels(){
        return  houseRentRepo.findAll();
    }
    // Get Api Owner Method end


    // Post Api Owner Method Start
    @PostMapping("/house")
    public HouseRentModel saveOwner(@RequestBody HouseRentModel houseRentModel){
        return houseRentRepo.save(houseRentModel);
    }
    // Post Api Owner Method end


    // Delete Api Owner Method Start
    private final HouseRentService houseRentService;

    public RestHouseRentController(HouseRentService houseRentService) {
        this.houseRentService = houseRentService;
    }

    @DeleteMapping("/house/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable("id") Integer id) {
        Optional<HouseRentModel> exists=houseRentRepo.findById(id);
        if (exists.isEmpty()) {
            return new ResponseEntity<>("HouseRentModel not found", HttpStatus.NOT_FOUND);
        }
        houseRentService.deleteHouseRent(id);
        return new ResponseEntity<>("HouseRentModel deleted successfully", HttpStatus.OK);
    }
    // Post Api Owner Method end







}
