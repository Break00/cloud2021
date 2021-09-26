package com.jason.lee.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.jason.lee.dao"})
public class MyBatisConfig {
}
