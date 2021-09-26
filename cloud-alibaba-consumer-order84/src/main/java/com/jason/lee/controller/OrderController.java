package com.jason.lee.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jason.lee.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private RestTemplate restTemplate;

    @Resource
    private PaymentFeignService paymentFeignService;

    public static final String PAYMENT_URL = "http://cloud-payment-service/payment";

    @GetMapping("/testA/{id}")
    @SentinelResource(value = "testA", blockHandler = "deal_testA",fallback = "deal_fallback")
    public String testA(@PathVariable("id") String id) {
        if (StrUtil.equals(id, "error")) {
            throw new RuntimeException("RuntimeException");
        }
        return restTemplate.getForObject(PAYMENT_URL + "/testA", String.class);
    }

    @GetMapping("/testB")
    public String testB() {
        return restTemplate.getForObject(PAYMENT_URL + "/testB", String.class);
    }

    // sentinel配置生效
    public String deal_testA(@PathVariable("id") String id, BlockException exception) {
        log.info("exception: {}", exception);
        return "Exception!!!";
    }

    // Java运行时异常
    public String deal_fallback(@PathVariable("id") String id, Throwable throwable) {
        log.info("throwable: {}", throwable);
        return "Throwable!!!";
    }

    @GetMapping("/feign/testA")
    public String testA_Feign(){
        return paymentFeignService.testA();
    }

}
