package com.jason.lee.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author huanli9
 * @description
 * @date 2021/3/21 16:12
 */
@Slf4j
@EnableBinding(Sink.class)
public class MessageListener {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消息接受者端口{}，消息内容{}", port, message.getPayload());
    }
}
