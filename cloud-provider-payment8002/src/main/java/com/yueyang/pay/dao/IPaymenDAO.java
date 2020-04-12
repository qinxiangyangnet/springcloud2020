package com.yueyang.pay.dao;

import com.yueyang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: springcloud2020
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-11 14:48
 **/
@Mapper
public interface IPaymenDAO {

    Long create(Payment payment);

    Payment  findById(Long id);
}