package com.heideng.borrowservice.entity;

import com.heideng.entity.Book;
import com.heideng.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentBorrowDetail {
    Student student;
    List<Book> bookList;
}
