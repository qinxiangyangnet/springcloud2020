package com.yueyang.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-15 07:45
 **/
@Component
@FeignClient(value = "cloud-provider-hystrix-service",fallback = PaymentFallback.class)
public interface PaymentHystriService {


    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timetout/{id}")
    String paymentInfo_timetout(@PathVariable("id") Integer id);
}