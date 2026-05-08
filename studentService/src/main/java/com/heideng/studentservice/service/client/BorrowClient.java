package com.heideng.studentservice.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("borrowService")
public class BorrowClient {

}
