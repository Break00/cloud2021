package com.jason.lee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author huanli9
 * @description
 * @date 2021/3/14 11:05
 */
@Component
@FeignClient(value = "cloud-payment-service-hystrix", fallback = PaymentFeignFallBackService.class)
public interface PaymentFeignService {

    @GetMapping("payment/hystrix/ok/{id}")
    String getPaymentOk(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    String getPaymentTimeout(@PathVariable("id") Integer id);
}
