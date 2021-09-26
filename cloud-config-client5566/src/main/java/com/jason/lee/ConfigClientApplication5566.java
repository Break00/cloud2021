package com.jason.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:16
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication5566 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication5566.class, args);
    }
}
