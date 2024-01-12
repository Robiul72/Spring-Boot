package com.GM.GarmentsManagement.controller;


import com.GM.GarmentsManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/add")
    public String home(){

        return "index";
    }

}
