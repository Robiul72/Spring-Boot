//package com.houserent.HouseRent.restController;
//
//import com.houserent.HouseRent.model.OwnerModel;
//import com.houserent.HouseRent.repository.IOwnerRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin("*")
//public class OwnerController {
//
//    @Autowired
//    private IOwnerRepo ownerRepo;
//
//    @GetMapping("/owner")
//    public List<OwnerModel> allOwner(){
//
//        return  ownerRepo.findAll();
//    }
//
//    @PostMapping("/owner")
//    public OwnerModel saveOwner(@RequestBody OwnerModel ownerModel){
//        return ownerRepo.save(ownerModel);
//
//    }
//
//    @DeleteMapping("/owner/{id}")
//    public ResponseEntity<String> deleteOwner(@PathVariable ("id") int id){
//
//        boolean esist=ownerRepo.existsById(id);
//
//        if(esist){
//            ownerRepo.deleteById(id);
//
//            return new ResponseEntity<>(" Owner is deleted", HttpStatus.OK);
//        }
//        return new ResponseEntity<>(" Owner is not deleted", HttpStatus.BAD_REQUEST);
//
//    }
//
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
//
//
//}
