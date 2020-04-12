package com.yueyang.order.configuer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-12 05:45
 **/
@Configuration
public class ApplicationContextConfig {



    @Bean
    public RestTemplate  getRestTemplate(){
        return new RestTemplate();
    }
}