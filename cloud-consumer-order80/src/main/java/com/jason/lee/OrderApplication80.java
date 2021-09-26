package com.jason.lee;

import com.jason.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author huanli9
 * @description
 * @date 2021/3/9 23:16
 */
@RibbonClient(name="cloud-payment-service",configuration = MyRule.class)  //自定义负载规则
@EnableEurekaClient
@SpringBootApplication
public class OrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class, args);
    }
}
