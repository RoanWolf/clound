package com.heideng.borrowservice.service.client;

import com.heideng.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bookService")
public interface BookClient {

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable long id);
}
