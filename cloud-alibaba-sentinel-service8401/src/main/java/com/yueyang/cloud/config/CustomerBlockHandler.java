package com.yueyang.cloud.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yueyang.springcloud.entities.CommonResult;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-02 10:54
 **/
@Configuration
public class CustomerBlockHandler {


    public   static  CommonResult  handelerEception(BlockException block){

        return new CommonResult(444, block.getClass().getCanonicalName() + "\t  服务不可用---1");
    }


    public   static  CommonResult  handelerEception2(BlockException block){

        return new CommonResult(444, block.getClass().getCanonicalName() + "\t  服务不可用---2");
    }
}