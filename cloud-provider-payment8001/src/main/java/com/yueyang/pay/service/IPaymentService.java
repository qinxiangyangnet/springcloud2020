package com.yueyang.pay.service;


import com.yueyang.springcloud.entities.Payment;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-11 14:50
 **/
public interface IPaymentService {

    Long create(Payment payment);

    Payment  findById(Long id);
}