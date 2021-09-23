package com.kkwli.springcloud;

import com.kkwli.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient /*开启加入注册中心*/
//@RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class) /*Ribbon负载规则替换*/
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
