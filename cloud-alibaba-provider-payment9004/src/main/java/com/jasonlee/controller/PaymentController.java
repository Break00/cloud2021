package com.jasonlee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanli9
 * @description
 * @date 2021/3/10 22:04
 */
@Slf4j
@RequestMapping("/payment")
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/testA")
    public String testA() {
        return port + "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return port + "testB";
    }
}
