package com.yueyang.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-18 08:03
 **/
@Component
public class PaymentFallback implements PaymentHystriService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "ok  fasdkfjasd";
    }

    @Override
    public String paymentInfo_timetout(Integer id) {
        return "timeout fadsfdsa";
    }
}