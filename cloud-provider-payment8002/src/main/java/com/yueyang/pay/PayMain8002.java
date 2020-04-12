package com.yueyang.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-12 10:17
 **/
@SpringBootApplication
@EnableEurekaClient
public class PayMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain8002.class,args);
    }
}