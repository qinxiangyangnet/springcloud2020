package com.yueyang.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-02 05:40
 **/
@RestController
@Slf4j
public class FlowLimitController {


    @GetMapping(value = "/testA")
    public String testA() {
        return "testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "......testB");
        return "testB";
    }


    @GetMapping(value = "/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
            log.info("testD  RT");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testB";
    }

    @GetMapping(value = "/testE")
    public String testE() {

        log.info("testE  异常比例");
        int age = 10 / 0;

        return "testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2,
                             @RequestParam(value = "p3", required = false) String p3
    ) {

        return "...............testHotKey";
    }

    public String deal_testHotKey(String p1,
                                  String p2,
                                  String p3,
                                  BlockException exception
    ) {

        return "------------------deal_testHotKey";

    }
}