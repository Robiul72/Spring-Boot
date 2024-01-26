package com.houserent.HouseRent.service;

import com.houserent.HouseRent.model.CustomerFrom;
import com.houserent.HouseRent.model.HouseRentModel;
import com.houserent.HouseRent.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private ICustomerRepo customerRepo;


    public void saveCustomer(CustomerFrom customer){
        customerRepo.save(customer);
    }



    public List<CustomerFrom> getAllStuCustomer(){
        return customerRepo.findAll();
    }

    public  void deleteCustomer(int id){
        customerRepo.deleteById(id);
    }

    public CustomerFrom findById(int id){

        return  customerRepo.findById(id).get();
    }

    public List<CustomerFrom> getAllCustomer() {
        return customerRepo.findAll();
    }
}
