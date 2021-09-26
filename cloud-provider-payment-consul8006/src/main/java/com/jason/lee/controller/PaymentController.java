package com.jason.lee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
    private String serverPort;

    @GetMapping("/consul")
    public String  getRandomId() {
        return UUID.randomUUID().toString();
    }
}
