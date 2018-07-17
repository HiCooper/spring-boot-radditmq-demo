package com.berry.springbootrebbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Title
 * Description
 * Copyright (c) 2018
 * Company  上海思贤信息技术股份有限公司
 *
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/17 10:44
 */
@Component
@RabbitListener(queues = "hello")
public class FanoutReceiverHello {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver Hello : " + message);
    }
}
