package com.kkwli.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "1000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        /*int age = 10/0;*/
        try {

            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "\tpaymentInfo_TimeOut,id:" + id + "\t哈哈,耗时" + timeNumber + "秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "\tpaymentInfo_TimeOutHandler,id:" + id + "\t(っ °Д °;)っ";
    }

}
