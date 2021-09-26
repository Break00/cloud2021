package com.jason.lee.service;

import com.jason.lee.entities.Payment;
import com.jason.lee.mapper.PaymentMapper;
import com.jason.lee.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huanli9
 * @description
 * @date 2021/3/10 22:02
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {

        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentMapper.selectByPrimaryKey(id);
    }
}
