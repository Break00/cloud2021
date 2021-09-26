package com.jason.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:16
 */
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class OrderApplicationOpenFeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationOpenFeignHystrix80.class, args);
    }
}
