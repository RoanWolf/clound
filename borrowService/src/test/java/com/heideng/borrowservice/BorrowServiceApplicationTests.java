package com.heideng.borrowservice;

import com.heideng.borrowservice.entity.StudentBorrowDetail;
import com.heideng.borrowservice.service.BorrowService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BorrowServiceApplicationTests {
    @Resource
    BorrowService borrowService;

    @Test
    void contextLoads() {
        StudentBorrowDetail studentBorrowDetailByUid = borrowService.getStudentBorrowDetailBySid(2);
        System.out.println(studentBorrowDetailByUid);
    }

}
