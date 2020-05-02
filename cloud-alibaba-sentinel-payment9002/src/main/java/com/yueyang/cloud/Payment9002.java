package com.yueyang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-02 11:21
 **/

@SpringBootApplication

@EnableDiscoveryClient
public class Payment9002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9002.class, args);
    }
}