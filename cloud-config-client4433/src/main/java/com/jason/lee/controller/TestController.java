package com.jason.lee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanli9
 * @description
 * @date 2021/3/20 16:44
 */
@RefreshScope  // 刷新配置
@RestController
public class TestController {

    @Value("${profile}")
    private String profileName;

    @GetMapping("/getProfile")
    public String getProfile(){
        return profileName;
    }
}
