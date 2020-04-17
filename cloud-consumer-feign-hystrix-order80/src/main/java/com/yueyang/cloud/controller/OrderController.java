package com.yueyang.cloud.controller;

import com.yueyang.cloud.service.PaymentHystriService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-15 07:47
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentHystriService paymentHystriService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Integer id) {

        String result = paymentHystriService.paymentInfo_ok(id);
        return result;
    }

    @GetMapping("/consumer/hystrix/timetout/{id}")
    String paymentInfo_timetout(@PathVariable("id") Integer id) {

        String result = paymentHystriService.paymentInfo_ok(id);
        return result;
    }
}