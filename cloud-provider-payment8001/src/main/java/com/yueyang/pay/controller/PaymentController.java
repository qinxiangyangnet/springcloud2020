package com.yueyang.pay.controller;


import com.yueyang.pay.service.IPaymentService;
import com.yueyang.springcloud.entities.CommonResult;
import com.yueyang.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-11 15:01
 **/
@RestController
@Slf4j
public class PaymentController {
    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 对于注册进eureka的微服务，可以通过服务发现来获得该服务的信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        Long result = paymentService.create(payment);
        logger.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功 serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.findById(id);
        logger.info("*****插入结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功 serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        //获取服务列表
        List<String> services = discoveryClient.getServices();
        for (String ele : services) {
            log.info("*****************ele: " + ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("*****************instance: " + instance.getHost() + " " + instance.getServiceId() + " " + instance.getUri() + " " + instance.getPort());
        }
        return this.discoveryClient;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentTimeout() {
        try {
            Thread.sleep(3000);

        } catch (Exception e) {

        }
        return serverPort;
    }


}