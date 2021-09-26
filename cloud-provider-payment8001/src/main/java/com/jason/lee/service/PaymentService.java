package com.jason.lee.service;

import com.jason.lee.entities.Payment;

/**
 * @author huanli9
 * @description
 * @date 2021/3/10 22:00
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
