package com.lyh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyh.springcloud.alibaba.handler.CustomerBlockHandler;
import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author martin
 * @date 2021/2/17
 **/

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试", new Payment(1L, "serial001"));
    }

    public CommonResult<Payment> handleException(BlockException blockException) {
        return new CommonResult<>(-1, blockException.getClass().getCanonicalName() + "\t服务不可用", null);
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<>(200, "按URL限流测试", new Payment(2L, "serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "客户自定义", new Payment(3L, "serial003"));
    }
}
