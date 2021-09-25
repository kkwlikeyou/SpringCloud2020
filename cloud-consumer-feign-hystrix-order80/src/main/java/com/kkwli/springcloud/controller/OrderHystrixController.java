package com.kkwli.springcloud.controller;


import com.kkwli.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author kkwli
 * @Date 2021/9/25 9:01
 * @注释
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);

    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "1500")
    })*/
    @HystrixCommand
    String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }


    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "\t客户端服务降级,id:" + id + "\t(っ °Д °;)っ";
    }

    //下面是全局fallback方法
    public String defaultFallback() {
        return "客户端服务降级";
    }
}
