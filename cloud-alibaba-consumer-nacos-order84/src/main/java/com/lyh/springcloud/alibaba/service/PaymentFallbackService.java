package com.lyh.springcloud.alibaba.service;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author martin
 * @date 2021/2/18
 **/

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult<>(-1, "PaymentFallbackService: 服务降级", new Payment(id, "null"));
    }
}
