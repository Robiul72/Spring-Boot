package com.houserent.HouseRent.restController;

import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.model.OwnerModel;
import com.houserent.HouseRent.repository.IHouseRentRepo;
import com.houserent.HouseRent.repository.IOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestOwnerController {

    @Autowired
    private IOwnerRepo ownerRepo;

    @Autowired
    private IHouseRentRepo houseRentRepo;


    // Get Api Owner Method Start
    @GetMapping("/owner")
    public List<OwnerModel> allOwner(){
        return  ownerRepo.findAll();
    }
    // Get Api Owner Method end


    // Post Api Owner Method Start
    @PostMapping("/owner")
    public OwnerModel saveOwner(@RequestBody OwnerModel ownerModel){
        return ownerRepo.save(ownerModel);
    }
    // Post Api Owner Method end



//    @DeleteMapping("/owner/{id}")
//    public ResponseEntity<String> deleteOwner(@PathVariable("id") int id) {
//
//        if (ownerRepo.existsById(id)) {
////            ownerRepo.deleteById(id);
//
//            // Assuming you have a corresponding field in HouseRentModel for the owner ID
////            List<HouseRentModel> houses = houseRentRepo.findByOwner_Id(id);
//            List<HouseRentModel> houses = houseRentRepo.findByOwner_Name(id);
//            if (!houses.isEmpty()) {
////                houseRentRepo.deleteAll(houses);
//                System.out.println(houses);
//            }
//
//            return new ResponseEntity<>(" house found.", HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("Owner not found", HttpStatus.NOT_FOUND);
//    }



//    @DeleteMapping("/owner/{id}")
//    public ResponseEntity<String> deleteOwner(@PathVariable ("id") int id){
//
//        boolean esist=ownerRepo.existsById(id);
//
//        if(esist){
//            ownerRepo.deleteById(id);
//
//            houseRentRepo.deleteById((long) id);
//
//            return new ResponseEntity<>(" Owner is deleted", HttpStatus.OK);
//        }
//        return new ResponseEntity<>(" Owner is not deleted", HttpStatus.BAD_REQUEST);
//
//    }




//    @DeleteMapping("/owner/{id}")
//    public ResponseEntity<String> deleteOwner(@PathVariable("id") int id) {
//
//        Optional<OwnerModel> ownerOptional = ownerRepo.findById(id);
//
//        if (ownerOptional.isPresent()) {
//            OwnerModel owner = ownerOptional.get();
//
//            // Delete associated houses
//            List<HouseRentModel> houses = owner.getHouses();
//
//            for (HouseRentModel house : houses) {
//                houseRentRepo.deleteById(Long.valueOf(house.getId()));
//            }
//
//            // Delete the owner
//            ownerRepo.deleteById(id);
//
//            return new ResponseEntity<>("Owner and associated houses are deleted", HttpStatus.OK);
//        }

//        return new ResponseEntity<>("Owner is not deleted. Owner not found", HttpStatus.BAD_REQUEST);
//    }




//    @PutMapping("/owner/{id}")
//    public ResponseEntity<String> updateOwner(@PathVariable ("id") int id, @RequestBody OwnerModel old){
//
//        boolean esist=ownerRepo.existsById(id);
//
//        if(esist){
//            OwnerModel newO=ownerRepo.findById(id).get();
//            newO.setH_Rent_Owner_Name(old.getH_Rent_Owner_Name());
//            newO.setH_Rent_Email(old.getH_Rent_Email());
//            newO.setH_Rent_Mobile(old.getH_Rent_Mobile());
//            newO.setId(id);
//
//            ownerRepo.save(newO);
//
//            return new ResponseEntity<>(" Owner is Update", HttpStatus.OK);
//        }
//        return new ResponseEntity<>(" Owner is not Update", HttpStatus.BAD_REQUEST);
//
//    }


}
