package com.lyh.springcloud.alibaba.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author martin
 * @date 2021/2/19
 **/

@Data
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
