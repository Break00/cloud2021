package com.jason.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication83.class, args);
    }
}
