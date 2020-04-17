package com.yueyang.cloud.controller;

import com.yueyang.cloud.service.PaymentFeignService;
import com.yueyang.springcloud.entities.CommonResult;
import com.yueyang.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-13 22:56
 **/
@RestController
@Slf4j
public class OpenFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping(value = "/consumer/feign/timeout")
    public String paymentTimeout() {
        return paymentFeignService.paymentTimeout();
    }
}