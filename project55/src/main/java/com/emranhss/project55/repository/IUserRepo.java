package com.emranhss.project55.repository;

import com.emranhss.project55.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

    @Query("select  u from User u where u.email=:email")
    Optional<User> findByEmail(@Param("email") String email);

}
