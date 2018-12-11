package com.berry.springbootrebbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 广播交换器队列绑定的队列接收器
 * Title
 * Description
 * Copyright (c) 2018
 *
 * @author HiCooper
 * @version 1.0
 * @date 2018/12/11 17:53
 */
@Component
public class FanoutQueueReceiver {

    private static Random random =new Random();

    @RabbitListener(queues = "fanoutA")
    @RabbitHandler
    public void fanoutA(String msg) throws InterruptedException {
        System.out.println("fanoutA:" + msg);
        Thread.sleep(random.nextInt(10000));
    }

    @RabbitListener(queues = "fanoutB")
    @RabbitHandler
    public void fanoutB(String msg) throws InterruptedException {
        System.out.println("fanoutB:" + msg);
        Thread.sleep(random.nextInt(10000));
    }
}
