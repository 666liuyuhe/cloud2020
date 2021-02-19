package com.lyh.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author martin
 * @date 2021/2/19
 **/
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
