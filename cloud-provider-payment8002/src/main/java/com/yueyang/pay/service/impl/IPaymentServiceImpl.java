package com.yueyang.pay.service.impl;

import com.yueyang.pay.dao.IPaymenDAO;
import com.yueyang.pay.service.IPaymentService;
import com.yueyang.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-11 14:50
 **/
@Service
public class IPaymentServiceImpl implements IPaymentService {

    @Resource
    private IPaymenDAO paymenDAO;

    @Override
    public Long create(Payment payment) {
        return paymenDAO.create(payment) > 0 ? payment.getId() : 0L;
    }

    @Override
    public Payment findById(Long id) {
        return paymenDAO.findById(id);
    }
}