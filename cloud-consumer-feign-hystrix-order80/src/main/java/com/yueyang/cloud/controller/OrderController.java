package com.yueyang.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yueyang.cloud.service.PaymentHystriService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimenHandler",commandKey="paymentInfo_timeout",groupKey="PGroup",
            threadPoolKey="paymentInfo_timeoutThread",commandProperties = {
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "9000"),

    })
    String paymentInfo_timetout(@PathVariable("id") Integer id) {

        String result = paymentHystriService.paymentInfo_timetout(id);
        return result;
    }


    public String paymentInfo_TimenHandler(Integer id) {

        //温馨友好提示
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimenHandler,id" + id + "\t" + "80服务器在忙，请稍后尝试";
    }
}