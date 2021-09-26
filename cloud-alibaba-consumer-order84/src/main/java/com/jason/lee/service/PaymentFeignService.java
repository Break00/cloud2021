package com.jason.lee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huanli9
 * @description
 * @date 2021/3/14 11:05
 */
@Component
@FeignClient(value = "cloud-payment-service", fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {

    @GetMapping("payment/testA")
    String testA();

}
