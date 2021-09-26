package com.jason.lee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author huanli9
 * @description
 * @date 2021/3/10 22:04
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @GetMapping("/zk")
    public String getRandomId() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
