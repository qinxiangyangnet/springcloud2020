package com.yueyang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-25 11:05
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer83.class, args);
    }
}