package com.houserent.HouseRent.repository;

import com.houserent.HouseRent.model.CustomerFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository <CustomerFrom, Integer> {

}
