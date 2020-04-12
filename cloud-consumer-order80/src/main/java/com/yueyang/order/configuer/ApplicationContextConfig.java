package com.yueyang.order.configuer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-12 05:45
 **/
@Configuration
public class ApplicationContextConfig {


    //@LoadBalanced赋予RestTemplate负载均衡，用于集群的情况
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}