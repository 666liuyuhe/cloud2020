package com.lyh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author martin
 * @date 2021/2/8
 **/

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderConsulController {
    public static final String INVOKE_URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        log.info(result);
        return result;
    }
}
