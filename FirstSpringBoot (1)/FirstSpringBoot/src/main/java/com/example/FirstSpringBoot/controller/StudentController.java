package com.example.FirstSpringBoot.controller;

import com.example.FirstSpringBoot.model.Department;
import com.example.FirstSpringBoot.model.Student;
import com.example.FirstSpringBoot.repository.StudentRepo;
import com.example.FirstSpringBoot.service.DepartmentService;
import com.example.FirstSpringBoot.service.StudentService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService dService;

    @GetMapping("/")
    public String allStudent(Model m) {

        List<Student> studentList=studentService.getAllStudent();
        m.addAttribute("studentList", studentList);
        m.addAttribute("title", "All Student");
        return "studenthome";
    }

    @GetMapping("/addform")
    public String addStudent(Model m) {
        // data comes from Department table using List, DepartmentService
        List<Department> depList=dService.getAllDepartment();

    // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department", new Department());
        m.addAttribute("depList", depList);

        m.addAttribute("student", new Student());
        m.addAttribute("title", "Add Student");

        return "addstudent";
    }


    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student s) {
        studentService.saveStudent(s);
        return "redirect:/student/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "redirect:/student/";
    }

    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model m){
        Student s=studentService.findById(id);
        m.addAttribute("student", s);
        return "addstudent";
    }

}
