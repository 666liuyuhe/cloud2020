package com.lyh.springcloud.service;

/**
 * @author martin
 * @date 2021/2/9
 **/
public interface PaymentService {
    String paymentInfoOk(Integer id);

    String paymentInfoTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
