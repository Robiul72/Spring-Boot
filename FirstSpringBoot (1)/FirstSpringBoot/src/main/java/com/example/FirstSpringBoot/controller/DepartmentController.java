package com.example.FirstSpringBoot.controller;

import com.example.FirstSpringBoot.model.Department;
import com.example.FirstSpringBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department/")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/")
    public String getAllDepartment(Model m){
        List<Department> depList=service.getAllDepartment();
        m.addAttribute("depList", depList);
        m.addAttribute("title", "All Department");
        return  "viewDepartment";
    }

    @GetMapping("/addform")
    public  String addForm(Model m){

        m.addAttribute("department", new Department());
        m.addAttribute("title", "Add Department");

        return "adddepartment";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  String addDepartment(@ModelAttribute Department d){
        service.save(d);
        return "redirect:/department/";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id){
        service.deleteDepartment(id);
        return "redirect:/department/";
    }

    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable int id, Model m){
       Department d= service.editDepartment(id);
       m.addAttribute("department", d);

        return "adddepartment";
    }


}
