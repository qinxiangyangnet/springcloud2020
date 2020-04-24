package com.yueyang.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-24 23:48
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveController {


    @Value("${server.port}")
    private String serverSort;


    @StreamListener(Sink.INPUT)
    public void input(Message<Object> message) {
        //与withpayLoad相反
        System.out.println(message.getPayload() + "   port:" + serverSort);
    }
}