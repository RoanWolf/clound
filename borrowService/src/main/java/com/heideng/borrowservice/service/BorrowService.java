package com.heideng.borrowservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heideng.borrowservice.entity.StudentBorrowDetail;
import com.heideng.entity.Borrow;


public interface BorrowService extends IService<Borrow> {
    StudentBorrowDetail getStudentBorrowDetailBySid(long uid);
}
