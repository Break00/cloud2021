package com.jason.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:16
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication9002.class, args);
    }
}
