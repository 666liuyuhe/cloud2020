package com.lyh.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author martin
 * @date 2021/2/18
 **/
@Configuration
@MapperScan({"com.lyh.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
