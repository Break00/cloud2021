package com.jason.lee.service;

import org.springframework.stereotype.Component;

/**
 * @author huanli9
 * @description
 * @date 2021/3/15 20:40
 */
@Component
public class PaymentFeignFallBackService implements PaymentFeignService {
    @Override
    public String getPaymentOk(Integer id) {
        return "getPaymentOk fall back";
    }

    @Override
    public String getPaymentTimeout(Integer id) {
        return "getPaymentTimeout fall back";
    }
}