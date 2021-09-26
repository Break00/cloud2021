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
public class ConfigClientApplication3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3377.class, args);
    }
}
