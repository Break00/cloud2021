package com.jason.lee.service;

import org.springframework.stereotype.Component;

/**
 * @author huanli9
 * @description
 * @date 2021/4/1 16:02
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public String testA() {
        return "testA fallback";
    }
}
