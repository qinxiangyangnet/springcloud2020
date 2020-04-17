package com.yueyang.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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
     *
     * @param id
     * @return
     */
    public String paymentInfo_timeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {

        }

        return "线程池" + Thread.currentThread().getName() + "paymentInfo_error,id" + id + "\t" + "o(╥﹏╥)o哼哼" + "h耗时：" + timeNumber;
    }
}