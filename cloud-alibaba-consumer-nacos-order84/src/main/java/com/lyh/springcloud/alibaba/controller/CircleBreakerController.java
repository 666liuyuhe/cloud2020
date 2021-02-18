package com.lyh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyh.springcloud.alibaba.service.PaymentService;
import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author martin
 * @date 2021/2/18
 **/

@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/{id}")
    //@SentinelResource(value = "fallback") // 没有配置
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")  // fallback只负责业务异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler只负责Sentinel控制台违规配置
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    // 若blockHandler和fallback都进行了配置，则被限流降级而抛出BlockException时只会进入blockHandler处理逻辑
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/payment/" + id, CommonResult.class, id);
        if (id == 5) {
            throw new IllegalArgumentException("参数非法");
        } else if (result.getData() == null) {
            throw new NullPointerException("该ID没有对应的记录");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(-1, e.getMessage(), payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(-1, "blockException: " + blockException.getMessage(), payment);
    }

    // ==== OpenFeign ====
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/feign/{id}")
    public CommonResult<Payment> paymentByOpenFeign(@PathVariable("id") Long id) {
        return paymentService.payment(id);
    }
}
