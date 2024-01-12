package com.GM.GarmentsManagement.repository;

import com.GM.GarmentsManagement.employeeEntity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employee_Repository extends JpaRepository <Employee, Long > {

    @Query("select emp from Department emp where emp.dep_id= ?")

    public List<Employee> findByDept(long deptId);


    @Query("select  count (em.em_id) from Employee em")
    public int countRow();

    @Query("select em from Employee em where em.em_id=?")
    public Employee findByEmid(String emid);

}
