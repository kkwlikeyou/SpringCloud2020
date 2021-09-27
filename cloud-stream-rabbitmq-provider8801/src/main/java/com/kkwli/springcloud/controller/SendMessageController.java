package com.kkwli.springcloud.controller;

import com.kkwli.springcloud.service.IMessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname SendMessageController
 * @Since 2021/9/27 8:56
 * @Author by kkwli
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProviderService iMessageProviderService;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProviderService.send();
    }
}
