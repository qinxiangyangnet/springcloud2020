package com.yueyang.cloud.controller;

import com.yueyang.springcloud.entities.CommonResult;
import com.yueyang.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-02 11:22
 **/
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<Long, Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put(1L, new Payment(1L, "消费者111"));
        paymentMap.put(2L, new Payment(2L, "消费者112"));
        paymentMap.put(3L, new Payment(3L, "消费者113"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        Payment payment = paymentMap.get(id);
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(200, "from DB,serverPort" + serverPort, payment);
        return paymentCommonResult;
    }
}