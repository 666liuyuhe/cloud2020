package com.lyh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author martin
 * @date 2021/2/8
 **/

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String payment() {
        String result = "Spring Cloud with Consul: " + serverPort + "\t" + UUID.randomUUID().toString().replaceAll("-", "");
        log.info(result);
        return result;
    }
}
