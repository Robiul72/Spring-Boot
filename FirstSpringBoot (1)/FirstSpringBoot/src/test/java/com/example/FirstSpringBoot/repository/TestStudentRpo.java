package com.example.FirstSpringBoot.repository;

import com.example.FirstSpringBoot.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

@SpringBootTest
public class TestStudentRpo {

    @Autowired
    private StudentRepo repo;

    @Test
    public void testAddStudent() {
        // Initialize a new Student object
        Student student = new Student();
        student.setRoll(10);
        student.setName("Mamun");
        student.setEmail("mamun@ziuk.com");

        // Assertions for the initialized student object
        Assertions.assertThat(student).isNotNull();
        Assertions.assertThat(student.getId()).isNull(); // Assuming the id is initially null

        // Save the student to the repository
        Student savedStudent = repo.save(student);

        // Assertions for the saved student
        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(savedStudent.getId()).isNotNull().isGreaterThan(0);
    }

}
