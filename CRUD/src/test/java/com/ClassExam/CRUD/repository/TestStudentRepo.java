package com.ClassExam.CRUD.repository;


import com.ClassExam.CRUD.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStudentRepo {

    @Autowired
    private StudentRepo repo;

    private Student student;


    @Test

    public void testAddStudent(){

        student = new Student();

        student.setRoll(101);
        student.setName("Robiul");
        student.setMail("robiul@gmail.com");
        student.setSubject("JEE");

        Assertions.assertNotNull(student);
        Assertions.assertNull(student.getId());

        Student saveStudent = repo.save(student);

        Assertions.assertNotNull(saveStudent);
        Assertions.assertNotNull(saveStudent.getId());
        Assertions.assertTrue(saveStudent.getId() > 0);



    }
}
