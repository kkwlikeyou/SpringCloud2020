package com.kkwli.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Since 2021/9/29 9:49
 * @Author kkwli
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------A";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------B";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException blockException) {
        return "------deal_testHotkey";
    }
}
