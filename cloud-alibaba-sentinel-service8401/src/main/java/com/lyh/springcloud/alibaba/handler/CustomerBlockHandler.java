package com.lyh.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;

/**
 * @author martin
 * @date 2021/2/17
 **/

public class CustomerBlockHandler {
    public static CommonResult<Payment> handlerException(BlockException exception) {
        return new CommonResult<>(-1, "客户自定义, global handlerException", null);
    }
}
