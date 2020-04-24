package com.yueyang.cloud.test;

import com.yueyang.cloud.entity.User;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-23 09:30
 **/
public class Test1 {

    private static final int cal = 10;
    private static User uu = new User();


    public int compute() {
        int a = 1;
        int b = 1;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.compute();
        System.out.println("test");
    }
}