package com.jason.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huanli9
 * @description
 * @date 2021/3/14 9:43
 */
@Configuration
public class MyRule {

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
