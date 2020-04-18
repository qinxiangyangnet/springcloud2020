package com.yueyang.cloud.controller;

import com.yueyang.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-15 06:49
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {

        String result = paymentService.paymentInfo_ok(id);
        log.info("*************reulst" + result);
        return result;
    }


    @GetMapping("/payment/hystrix/timetout/{id}")
    public String paymentInfo_timetout(@PathVariable("id") Integer id) {

        String result = paymentService.paymentInfo_timeout(id);
        log.info("*************reulst" + result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String circuit(@PathVariable("id") Integer id) {

        String result = paymentService.paymentCircuibreaker(id);
        log.info("*************reulst" + result);
        return result;
    }
}