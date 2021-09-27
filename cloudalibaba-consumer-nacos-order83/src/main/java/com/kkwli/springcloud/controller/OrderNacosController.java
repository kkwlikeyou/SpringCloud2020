package com.kkwli.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Since 2021/9/27 14:31
 * @Author by kkwli
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/echo/{id}")
    public String echo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverURL + "/echo/" + id, String.class);
    }

}
