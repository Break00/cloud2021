package com.jason.lee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanli9
 * @description
 * @date 2021/3/10 22:04
 */
@Slf4j
@RefreshScope
@RestController
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get")
    public String getConfigInfo() {
        return configInfo;
    }
}
