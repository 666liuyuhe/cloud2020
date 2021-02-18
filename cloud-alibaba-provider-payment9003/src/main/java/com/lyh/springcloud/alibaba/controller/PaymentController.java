package com.lyh.springcloud.alibaba.controller;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author martin
 * @date 2021/2/18
 **/

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, UUID.randomUUID().toString().replaceAll("-", "")));
        hashMap.put(2L, new Payment(2L, UUID.randomUUID().toString().replaceAll("-", "")));
        hashMap.put(3L, new Payment(3L, UUID.randomUUID().toString().replaceAll("-", "")));
        hashMap.put(4L, new Payment(4L, UUID.randomUUID().toString().replaceAll("-", "")));
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200, "serverPort: " + serverPort, payment);
    }
}
