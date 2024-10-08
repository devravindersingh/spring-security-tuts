package com.ravinder.springsecuritytuts.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(123,"Maria"),
            new Student(124, "James"),
            new Student(125, "Anna")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student " + studentId + "not found"));
    }
}
