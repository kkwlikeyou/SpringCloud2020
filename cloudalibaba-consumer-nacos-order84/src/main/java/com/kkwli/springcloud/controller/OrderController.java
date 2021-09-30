package com.kkwli.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kkwli.springcloud.entities.CommonResult;
import com.kkwli.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Since 2021/9/30 9:42
 * @Author kkwli
 */
@RestController
public class OrderController {

    private static final String URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/paymentSQL/{id}")
    @SentinelResource(fallback = "fallback")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/paymentSQL/" + id, CommonResult.class);
    }
}
