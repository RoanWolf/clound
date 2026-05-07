package com.heideng.borrowservice.controller;


import com.heideng.borrowservice.entity.StudentBorrowDetail;
import com.heideng.borrowservice.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @GetMapping("/borrow/{sid}")
    public StudentBorrowDetail getBorrow(@PathVariable int sid) {
        return borrowService.getStudentBorrowDetailBySid(sid);
    }
}
