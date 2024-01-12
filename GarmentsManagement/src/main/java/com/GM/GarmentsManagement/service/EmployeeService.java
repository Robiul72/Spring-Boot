package com.GM.GarmentsManagement.service;


import com.GM.GarmentsManagement.employeeEntity.Employee;
import com.GM.GarmentsManagement.repository.Designation_Repository;
import com.GM.GarmentsManagement.repository.Employee_Repository;
import com.GM.GarmentsManagement.repository.SalaryGrade_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

@Autowired
   private Employee_Repository employeeRepository;


   private SalaryGrade_Repository salaryGradeRepository;


   private Designation_Repository designationRepository;


   public Optional<Employee> findEmpById(long id){

       return employeeRepository.findById(id);
   }

   public List<Employee> findAllEmp(){
       return employeeRepository.findAll();
   }

   public void saveEmployee(Employee em){
       employeeRepository.save(em);
   }

   public int getTotalEmp(){
       return employeeRepository.countRow();
   }

}
