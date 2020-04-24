package com.yueyang.cloud.controller;

import com.yueyang.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void input(Message<String> message) {
        //与withpayLoad相反
        System.out.println(message.getPayload() + "   port:" + serverSort);
    }
}