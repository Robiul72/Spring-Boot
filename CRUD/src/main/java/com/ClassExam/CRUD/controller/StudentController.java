package com.ClassExam.CRUD.controller;

import com.ClassExam.CRUD.model.Student;
import com.ClassExam.CRUD.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @GetMapping("/addform")
    public  String allStudent(Model m){

        m.addAttribute("student", new Student());
        m.addAttribute("title", "Add Student");

        return "student";
    }


    @GetMapping("/save")
    public  String saveStudent(@ModelAttribute Student student){

        repo.save(student);

        return "redirect:/";
    }


}
