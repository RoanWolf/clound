package com.heideng.borrowservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heideng.borrowservice.entity.StudentBorrowDetail;
import com.heideng.borrowservice.mapper.BorrowMapper;
import com.heideng.borrowservice.service.BorrowService;
import com.heideng.borrowservice.service.client.BookClient;
import com.heideng.borrowservice.service.client.StudentClient;
import com.heideng.entity.Book;
import com.heideng.entity.Borrow;
import com.heideng.entity.Student;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, Borrow> implements BorrowService {
    @Resource
    StudentClient studentClient;

    @Resource
    BookClient bookClient;

    @Override
    public StudentBorrowDetail getStudentBorrowDetailBySid(long sid) {
        // 取出这个学生的所有借阅信息
        QueryWrapper<Borrow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", sid);
        List<Borrow> borrowList = this.baseMapper.selectList(queryWrapper);

        if (borrowList == null || borrowList.isEmpty()) {
            return null;
        }


        // 现在 需要去访问 学生接口 得到 Student对象 id 8082
        // 现在 需要去访问 书本接口 得到 Book对象 List id 8080
        Student student = studentClient.getStudentById(sid);

        // 4. 调用图书服务，获取每本书的详细信息
        List<Book> bookList = borrowList
                .stream()
                .map(borrow -> bookClient.getBookById(borrow.getBookId()))
                .collect(Collectors.toList());

        return new StudentBorrowDetail(student, bookList);


    }
}
