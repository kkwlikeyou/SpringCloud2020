package com.kkwli.springcloud.service;

import cn.hutool.core.util.IdUtil;
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

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
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

    //======服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreak.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreak.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreak.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreak.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功，流水号：" + serialNumber;

    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "id不能负数,请稍后再试/(ㄒoㄒ)/~~\tid:" + id;
    }

}
