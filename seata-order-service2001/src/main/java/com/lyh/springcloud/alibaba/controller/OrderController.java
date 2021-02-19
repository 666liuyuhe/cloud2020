package com.lyh.springcloud.alibaba.controller;

import com.lyh.springcloud.alibaba.domain.CommonResult;
import com.lyh.springcloud.alibaba.domain.Order;
import com.lyh.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author martin
 * @date 2021/2/18
 **/

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "创建订单成功");
    }
}
