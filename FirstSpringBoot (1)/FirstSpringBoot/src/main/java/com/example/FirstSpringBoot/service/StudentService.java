package com.example.FirstSpringBoot.service;

import com.example.FirstSpringBoot.model.Student;
import com.example.FirstSpringBoot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;


    public void saveStudent(Student s){
        repo.save(s);
    }


    public List<Student> getAllStudent(){
        return repo.findAll();
    }

    public  void deleteStudent(int id){
        repo.deleteById(id);
    }

    public Student findById(int id){

        return  repo.findById(id).get();
    }

}
