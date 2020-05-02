package com.yueyang.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yueyang.springcloud.entities.CommonResult;
import com.yueyang.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-02 11:22
 **/
@RestController
public class CirCleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String service_url;


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("consumer/fallback/{id}")
    // @SentinelResource(value = "fallback", fallback = "handlerFallBack")
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler_sentinel")
    @SentinelResource(value = "fallback", blockHandler = "blockHandler_sentinel", fallback = "handlerFallBack", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id) {

        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常---------id" + id);

        }
        CommonResult<Payment> result = restTemplate.getForObject(service_url + "/paymentSQL/" + id, CommonResult.class, id);
        if (result.getData() == null) {
            throw new NullPointerException("该Id没有对应额数据空指针异常");

        }
        return result;
    }

    /**
     * fallback  负责业务异常
     *
     * @param id
     * @param t
     * @return
     */
    public CommonResult handlerFallBack(Long id, Throwable t) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "兜底异常，handlerFallBack" + t.getMessage(), payment);
    }

    //负责sentinel配置台 的异常
    public CommonResult blockHandler_sentinel(Long id, BlockException t) {
        Payment payment = new Payment(id, null);
        return new CommonResult(445, "限流无此流水，blockHandler" + t.getMessage(), payment);
    }

}