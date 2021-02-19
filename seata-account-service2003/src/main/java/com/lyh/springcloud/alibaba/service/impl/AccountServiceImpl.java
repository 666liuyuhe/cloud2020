package com.lyh.springcloud.alibaba.service.impl;

import com.lyh.springcloud.alibaba.dao.AccountDao;
import com.lyh.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author martin
 * @date 2021/2/19
 **/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("---- 扣减余额 ----");
        accountDao.decrease(userId, money);
    }
}
