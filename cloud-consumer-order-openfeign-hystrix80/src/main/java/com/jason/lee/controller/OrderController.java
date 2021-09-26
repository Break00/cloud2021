package com.jason.lee.controller;

import com.jason.lee.dto.CommonResult;
import com.jason.lee.entities.Payment;
import com.jason.lee.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
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
@DefaultProperties(defaultFallback = "globalTimeoutHandler")
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/hystrix/ok/{id}")
    String getPaymentOk(@PathVariable Integer id){
        return paymentFeignService.getPaymentOk(id);
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @GetMapping("/hystrix1/timeout/{id}")
    String getPaymentTimeout1(@PathVariable Integer id){
        return paymentFeignService.getPaymentTimeout(id);
    }

    @HystrixCommand  // 全局降级方法
    @GetMapping("/hystrix2/timeout/{id}")
    String getPaymentTimeout2(@PathVariable Integer id){
        return paymentFeignService.getPaymentTimeout(id);
    }

    // 利用@FeignClient(value = "cloud-payment-service-hystrix", fallback = PaymentFeignFallBackService.class)
    // 进行服务降级
    @GetMapping("/hystrix3/timeout/{id}")
    String getPaymentTimeout3(@PathVariable Integer id){
        return paymentFeignService.getPaymentTimeout(id);
    }

    // 降级方法
    public String timeoutHandler(Integer id){
        return "Order Timeout当前线程：" + Thread.currentThread().getName();
    }

    // 全局降级方法
    public String globalTimeoutHandler(Integer id){
        return "Global Timeout当前线程：" + Thread.currentThread().getName();
    }
}
