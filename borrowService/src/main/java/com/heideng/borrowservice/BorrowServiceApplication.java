package com.heideng.borrowservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.heideng.borrowservice.mapper")
public class BorrowServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowServiceApplication.class, args);
    }

}
