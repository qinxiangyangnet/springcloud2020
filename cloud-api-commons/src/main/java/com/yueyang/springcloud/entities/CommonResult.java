package com.yueyang.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springcloud2020
 * @description: 封装返回类
 * @author: qinxiangyang
 * @create: 2020-04-11 14:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private  Integer code;

    private String  message;

    private T data;

    public  CommonResult(Integer code,String  message){
        this(code,message,null);
    }

}