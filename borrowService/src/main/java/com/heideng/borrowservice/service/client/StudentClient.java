package com.heideng.borrowservice.service.client;


import com.heideng.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("studentService")
public interface StudentClient {
    @GetMapping("/student/{sid}")
    Student getStudentById(@PathVariable("sid") long sid);
}
