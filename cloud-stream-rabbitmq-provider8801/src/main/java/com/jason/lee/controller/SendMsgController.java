package com.jason.lee.controller;

import com.jason.lee.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huanli9
 * @description
 * @date 2021/3/21 15:47
 */
@RestController
public class SendMsgController {

    @Resource
    private IMessageProvider provider;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        return provider.send();
    }
}
