package com.yueyang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-12 20:46
 **/


@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul.class, args);
    }
}