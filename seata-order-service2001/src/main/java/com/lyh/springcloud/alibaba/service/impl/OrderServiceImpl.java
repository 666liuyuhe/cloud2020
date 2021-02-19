package com.lyh.springcloud.alibaba.service.impl;

import com.lyh.springcloud.alibaba.dao.OrderDao;
import com.lyh.springcloud.alibaba.domain.Order;
import com.lyh.springcloud.alibaba.service.AccountService;
import com.lyh.springcloud.alibaba.service.OrderService;
import com.lyh.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author martin
 * @date 2021/2/18
 **/

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "lyh-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---- 新建订单 ----");
        orderDao.create(order);
        log.info("---- 订单服务调用库存服务（减库存） ----");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---- 订单服务调用账户服务（减金钱） ----");
        accountService.decrease(order.getUserId(), order.getMoney());
        // 修改订单的状态
        log.info("---- 修改订单状态 ----");
        orderDao.update(order.getUserId(), 0);
    }
}
