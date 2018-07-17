package com.berry.springbootrebbitmqdemo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title
 * Description
 * Copyright (c) 2018
 * Company  上海思贤信息技术股份有限公司
 *
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/17 10:43
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String context) {
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
}
