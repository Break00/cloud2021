package com.jason.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:16
 */
@EnableDiscoveryClient //该注解用于向consul或者zookeeper注册服务
@SpringBootApplication
public class PaymentApplicationConsul8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationConsul8006.class, args);
    }
}
