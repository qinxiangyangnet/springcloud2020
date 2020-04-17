package com.yueyang.cloud.service;

import com.yueyang.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-13 22:50
 **/
@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentTimeout();
}