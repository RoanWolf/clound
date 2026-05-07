package com.heideng.borrowservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heideng.borrowservice.entity.StudentBorrowDetail;
import com.heideng.borrowservice.mapper.BorrowMapper;
import com.heideng.borrowservice.service.BorrowService;
import com.heideng.entity.Book;
import com.heideng.entity.Borrow;
import com.heideng.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, Borrow> implements BorrowService {
    @Override
    public StudentBorrowDetail getStudentBorrowDetailBySid(int sid) {
        // 取出这个学生的所有借阅信息
        QueryWrapper<Borrow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", sid);
        List<Borrow> borrowList = this.baseMapper.selectList(queryWrapper);

        if (borrowList == null || borrowList.isEmpty()) {
            return null;
        }


        // 现在 需要去访问 学生接口 得到 Student对象 id 8082
        // 现在 需要去访问 书本接口 得到 Book对象 List id 8080
        RestTemplate restTemplate = new RestTemplate();
        String studentUrl = "http://localhost:8082/student/{sid}";
        Student student = restTemplate.getForObject(studentUrl, Student.class, sid);

        // 4. 调用图书服务，获取每本书的详细信息
        List<Book> bookList = borrowList
                .stream()
                .map(borrow -> restTemplate.getForObject("http://localhost:8080/book/{bookId}", Book.class, borrow.getBookId()))
                .collect(Collectors.toList());

        return new StudentBorrowDetail(student, bookList);


    }
}
