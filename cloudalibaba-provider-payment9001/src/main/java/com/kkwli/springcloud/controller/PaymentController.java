package com.kkwli.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Classname PaymentController
 * @Since 2021/9/27 13:56
 * @Author by kkwli
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String severPort;

    @GetMapping(value = "/echo/{id}")
    public String echo(@PathVariable("id") Integer id) {
        return "Hello Nacos Discovery, severPort:" + severPort + ",\tid:" + id;
    }
}
