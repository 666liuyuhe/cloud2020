package com.lyh.springcloud.controller;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import com.lyh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author martin
 * @date 2021/2/6
 **/

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("端口号："+ serverPort + "，插入结果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "添加成功", payment);
        } else {
            return new CommonResult<>(-1, "添加失败", null);
        }
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("端口号："+ serverPort + "，查询结果：" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "成功", payment);
        } else {
            return new CommonResult<>(-1, "失败", null);
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
