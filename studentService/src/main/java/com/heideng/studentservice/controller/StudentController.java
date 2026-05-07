package com.heideng.studentservice.controller;

import com.heideng.entity.Student;
import com.heideng.studentservice.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Resource
    StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentService.getById(id);
    }
}
