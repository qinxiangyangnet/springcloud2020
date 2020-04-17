package com.yueyang.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-15 06:40
 **/
@Service
public class PaymentService {


    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id) {

        return "线程池" + Thread.currentThread().getName() + "paymentInfo_ok,id" + id + "\t" + "O(∩_∩)O哈哈~";
    }


    /**
     * 非正常访问
     *划定红线
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimenHandler",commandKey="paymentInfo_timeout",groupKey="PGroup",
            threadPoolKey="paymentInfo_timeoutThread",commandProperties = {
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440"),

    })
    public String paymentInfo_timeout(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {

        }
       // int  age=10/0;


        return "线程池" + Thread.currentThread().getName() + "paymentInfo_error,id" + id + "\t" + "o(╥﹏╥)o哼哼" + "h耗时："+timeNumber ;
    }
    public String paymentInfo_TimenHandler(Integer id) {

        //温馨友好提示
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimenHandler,id" + id + "\t" + "服务器在忙，请稍后尝试";
    }
}