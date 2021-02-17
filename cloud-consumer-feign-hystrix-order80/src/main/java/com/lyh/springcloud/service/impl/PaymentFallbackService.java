package com.lyh.springcloud.service.impl;

import com.lyh.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author martin
 * @date 2021/2/9
 **/

@Component
public class PaymentFallbackService implements OrderHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "paymentInfoOK--->异常";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "paymentInfoTimeout--->异常";
    }
}
