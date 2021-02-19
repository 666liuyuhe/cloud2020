package com.lyh.springcloud.alibaba.service;

/**
 * @author martin
 * @date 2021/2/19
 **/
public interface StorageService {
    void decrease(Long productId, Integer count);
}
