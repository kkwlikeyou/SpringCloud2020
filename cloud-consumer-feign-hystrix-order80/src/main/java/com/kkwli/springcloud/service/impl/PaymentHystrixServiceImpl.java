package com.kkwli.springcloud.service.impl;

import com.kkwli.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author kkwli
 * @Since 2021/9/25 14:04
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentHystrixServiceImpl fallback-paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentHystrixServiceImpl fallback-paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}
