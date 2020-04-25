package com.yueyang.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-25 11:14
 **/
@RestController
public class NacosProviderController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos/provider/{id}")
    public String nacosDemo(@PathVariable("id") Long id) {
        return "nacos  registry,serverProt: "+serverPort+"  Id"+id;
    }

}