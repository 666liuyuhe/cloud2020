package com.lyh.springcloud.alibaba.dao;

import com.lyh.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author martin
 * @date 2021/2/18
 **/

@Mapper
public interface OrderDao {
    // 新建订单
    void create(Order order);
    // 修改订单
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
