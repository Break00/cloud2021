package com.jason.lee.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author huanli9
 * @description
 * @date 2021/3/14 10:20
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
