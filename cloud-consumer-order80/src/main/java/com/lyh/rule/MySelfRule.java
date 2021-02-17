package com.lyh.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author martin
 * @date 2021/2/9
 **/

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 随机
        return new RandomRule();
    }
}
