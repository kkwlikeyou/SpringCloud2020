package com.kkwli.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author kkwli
 * @Date 2021/9/25 7:59
 * @注释
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "\tpaymentInfo_OK,id:" + id + "\t哈哈";
    }

    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "\tpaymentInfo_TimeOut,id:" + id + "\t哈哈,耗时3秒";
    }
}
