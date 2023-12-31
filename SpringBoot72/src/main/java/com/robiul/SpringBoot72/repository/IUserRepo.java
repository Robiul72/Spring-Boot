package com.robiul.SpringBoot72.repository;


import com.robiul.SpringBoot72.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository <User, Integer> {

    @Query("select  u from  User u where u.email=:email")

    Optional<User> getUserByEmail (@Param("email")  String email);




}
