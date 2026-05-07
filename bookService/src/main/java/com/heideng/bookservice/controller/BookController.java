package com.heideng.bookservice.controller;

import com.heideng.bookservice.service.BookService;
import com.heideng.entity.Book;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable String id) {
        return bookService.getById(id);
    }
}
