package com.heideng.studentservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heideng.entity.Student;
import com.heideng.studentservice.mapper.StudentMapper;
import com.heideng.studentservice.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
