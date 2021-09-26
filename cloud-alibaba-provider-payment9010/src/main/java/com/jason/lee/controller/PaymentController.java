package com.jason.lee.controller;

import com.jason.lee.dto.CommonResult;
import com.jason.lee.entities.Payment;
import com.jason.lee.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huanli9
 * @description
 * @date 2021/3/10 22:04
 */
@Slf4j
@RequestMapping("/payment")
@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果：" + result, serverPort);
        if (result > 0) {
            return new CommonResult(200, serverPort + "success", result);
        } else {
            return new CommonResult(400, serverPort + "fail", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*******查询结果：" + result, serverPort);
        if (result != null) {
            return new CommonResult(200, serverPort + "success", result);
        } else {
            return new CommonResult(400, serverPort + "fail", null);
        }
    }

    // 获取Eureka服务器上注册的服务信息
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            System.out.println(service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        instances.forEach(instance -> {
            System.out.println(instance.getServiceId() + "#" + instance.getHost() + "#" + instance.getPort() + "#" + instance.getUri());
        });
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
