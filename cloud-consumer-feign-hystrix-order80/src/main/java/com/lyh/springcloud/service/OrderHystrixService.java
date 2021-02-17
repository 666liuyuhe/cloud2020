package com.lyh.springcloud.service;

import com.lyh.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author martin
 * @date 2021/2/9
 **/

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface OrderHystrixService {
    @GetMapping("payment/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id);

    @GetMapping("payment/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id);
}
