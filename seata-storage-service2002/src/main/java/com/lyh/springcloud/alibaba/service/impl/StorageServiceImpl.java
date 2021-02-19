package com.lyh.springcloud.alibaba.service.impl;

import com.lyh.springcloud.alibaba.dao.StorageDao;
import com.lyh.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author martin
 * @date 2021/2/19
 **/

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("---- 扣减库存 ----");
        storageDao.decrease(productId, count);
    }
}
