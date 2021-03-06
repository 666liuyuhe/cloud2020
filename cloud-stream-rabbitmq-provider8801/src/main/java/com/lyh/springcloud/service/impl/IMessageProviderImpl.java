package com.lyh.springcloud.service.impl;

import com.lyh.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author martin
 * @date 2021/2/16
 **/

@EnableBinding(Source.class) // 定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString().replaceAll("-", "");
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("serial: " + serial);
        return serial;
    }
}
