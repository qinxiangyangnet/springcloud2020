package com.yueyang.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yueyang.cloud.config.CustomerBlockHandler;
import com.yueyang.springcloud.entities.CommonResult;
import com.yueyang.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-02 10:37
 **/
@RestController
public class RateLimitController {


    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {

        return new CommonResult(200, "\t 按照资源名称限流ojbk", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException block) {

        return new CommonResult(444, block.getClass().getCanonicalName() + "\t  服务不可用");
    }


    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {

        return new CommonResult(200, "\t 按照url限流ojbk", new Payment(2020L, "serial002"));
    }


    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handelerEception2")
    public CommonResult customerBlockHandler() {

        return new CommonResult(200, "\t 按照客户端自定义", new Payment(2020L, "serial003"));
    }

}