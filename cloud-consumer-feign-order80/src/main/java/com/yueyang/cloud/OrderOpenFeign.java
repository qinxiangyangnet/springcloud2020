package com.yueyang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-13 22:49
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeign.class, args);
    }
}