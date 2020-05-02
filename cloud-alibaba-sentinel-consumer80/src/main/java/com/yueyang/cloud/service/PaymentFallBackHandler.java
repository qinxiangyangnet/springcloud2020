package com.yueyang.cloud.service;

import com.yueyang.springcloud.entities.CommonResult;
import com.yueyang.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-02 21:50
 **/
@Component
public class PaymentFallBackHandler implements PaymentService {
    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new CommonResult<>(444, "服务降级返回", new Payment(id, null));
    }
}