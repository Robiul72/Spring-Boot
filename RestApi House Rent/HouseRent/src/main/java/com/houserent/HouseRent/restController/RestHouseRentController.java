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

    @Autowired
    private HouseRentService houseRentService;


    // Get Api House Method Start
    @GetMapping("/house")
    public List<HouseRentModel> allHouseRentModels(){
        return  houseRentRepo.findAll();
    }
    // Get Api House Method end


    // Post Api House Method Start
    @PostMapping("/house")
    public HouseRentModel saveOwner(@RequestBody HouseRentModel houseRentModel){
        return houseRentRepo.save(houseRentModel);
    }
    // Post Api House Method end


    // Delete Api House Method Start
//    private final HouseRentService houseRentService;

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
    // Delete Api House Method end


    // Update Api House Method start
    @PutMapping("/house/{id}")
    public ResponseEntity<String> updateHouseRent(@PathVariable ("id") int id, @RequestBody HouseRentModel houseRentModel) {
        Optional<HouseRentModel> exiting = houseRentRepo.findById(id);

        if(exiting.isEmpty()){
           return new ResponseEntity<>("House Rent is Not Update", HttpStatus.NOT_FOUND);
        }

        houseRentService.updateHouseRent(exiting);
        return new ResponseEntity<>("House Rent is Update", HttpStatus.OK);

//        this.houseRentService.updateHouseRent(houseRentModel, id);
//
//        return houseRentModel;
    }
// Update Api House Method end




}
