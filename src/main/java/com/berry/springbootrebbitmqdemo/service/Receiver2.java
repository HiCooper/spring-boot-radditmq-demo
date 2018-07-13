package com.berry.springbootrebbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/13 13:02
 */
@Component
@RabbitListener(queues = "topic.message")
public class Receiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiver1:" + msg);
    }

}
