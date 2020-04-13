package com.yueyang.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-13 21:10
 **/
@Configuration
public class MySelfRule {


    @Bean
    public IRule myRule() {
        //定义为随机，默认为轮询  RoundRobinRule
        return new RandomRule();
    }
}