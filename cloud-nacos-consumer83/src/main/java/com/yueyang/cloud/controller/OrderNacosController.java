package com.yueyang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-25 11:14
 **/
@RestController
public class OrderNacosController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos/consumer")
    public String nacosDemo() {
        return serverPort;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    public String SERVER_URL;

    @GetMapping(value = "/consumer/nacos/payment/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(SERVER_URL + "/nacos/provider/" + id, String.class);
    }

}