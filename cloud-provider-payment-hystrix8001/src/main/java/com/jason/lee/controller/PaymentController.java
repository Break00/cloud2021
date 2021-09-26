package com.jason.lee.controller;

import com.jason.lee.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private PaymentServiceImpl paymentService;

    @GetMapping("/hystrix/ok/{id}")
    public String getPaymentOk(@PathVariable Integer id) {
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String getPaymentTimeout(@PathVariable Integer id) {
        return paymentService.paymentInfo_Timeout(id);
    }

    @GetMapping("/hystrix/break/{id}")
    public String paymentInfoCircuitBreaker(@PathVariable Integer id) {
        return paymentService.paymentInfoCircuitBreaker(id);
    }
}
