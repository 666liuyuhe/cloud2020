package com.lyh.springcloud.service;

import com.lyh.springcloud.entities.Payment;

/**
 * @author martin
 * @date 2021/2/6
 **/

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
