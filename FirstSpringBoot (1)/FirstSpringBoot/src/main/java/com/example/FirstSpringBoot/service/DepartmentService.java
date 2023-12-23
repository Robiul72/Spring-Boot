package com.example.FirstSpringBoot.service;

import com.example.FirstSpringBoot.model.Department;
import com.example.FirstSpringBoot.repository.IDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private IDepartmentRepo repo;

    public void save(Department d) {
        repo.save(d);
    }

    public List<Department> getAllDepartment() {

        return repo.findAll();
    }

    public void deleteDepartment(int id) {
        repo.deleteById(id);
    }

    public Department editDepartment(int id) {
        return repo.findById(id).get();
    }


}
