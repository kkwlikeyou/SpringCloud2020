package com.kkwli.springcloud.service.impl;

import com.kkwli.springcloud.service.IMessageProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Classname IMessageProviderServiceImpl
 * @Date 2021/9/27 8:47
 * @Created by kkwli
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class IMessageProviderServiceImpl implements IMessageProviderService {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial:" + serial);
        return null;
    }
}
