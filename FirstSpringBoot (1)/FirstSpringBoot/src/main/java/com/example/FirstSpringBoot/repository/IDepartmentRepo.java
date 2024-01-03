package com.example.FirstSpringBoot.repository;

import com.example.FirstSpringBoot.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepo extends JpaRepository<Department, Integer> {

}
