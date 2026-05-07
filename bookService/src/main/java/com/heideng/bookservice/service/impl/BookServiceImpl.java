package com.heideng.bookservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heideng.bookservice.mapper.BookMapper;
import com.heideng.bookservice.service.BookService;
import com.heideng.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
