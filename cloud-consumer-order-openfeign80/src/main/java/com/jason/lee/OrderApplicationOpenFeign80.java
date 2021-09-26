package com.jason.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:16
 */
@EnableFeignClients
@SpringBootApplication
public class OrderApplicationOpenFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationOpenFeign80.class, args);
    }
}
