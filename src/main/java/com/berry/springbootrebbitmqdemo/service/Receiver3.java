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
@RabbitListener(queues = "topic.messages")
public class Receiver3 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiver2 :" + msg);
    }


}
