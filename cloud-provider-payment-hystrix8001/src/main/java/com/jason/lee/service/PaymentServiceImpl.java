package com.jason.lee.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author huanli9
 * @description
 * @date 2021/3/10 22:02
 */
@Service
public class PaymentServiceImpl {

    public String paymentInfo_OK(Integer id) {
        return "Ok当前线程：" + Thread.currentThread().getName() + ", id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Timeout当前线程：" + Thread.currentThread().getName() + ", id:" + id;
    }

    // 降级方法
    public String paymentInfo_TimeoutHandler(Integer id){
        return "Payment Timeout当前线程：" + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "paymentInfoCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少跳闸
    })
    public String paymentInfoCircuitBreaker(Integer id) {
      if(id<0){
          throw new RuntimeException("id不能为负数");
      }
        return "Timeout当前线程：" + Thread.currentThread().getName() + ", id:" + id;
    }

    public String paymentInfoCircuitBreakerFallback(Integer id){
        return "请稍后再试";
    }
}
