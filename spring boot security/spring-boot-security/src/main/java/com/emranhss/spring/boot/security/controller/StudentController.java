package com.emranhss.spring.boot.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

    @RequestMapping("/saveform")
    public String studentForm(){

        return "student";
    }


    @RequestMapping("/all")
    public String allStudent(){

        return "allstudent";
    }
}
