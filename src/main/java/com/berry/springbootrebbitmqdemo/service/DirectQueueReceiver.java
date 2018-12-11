package com.berry.springbootrebbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 直连交换器队列绑定的队列接收器
 * Title
 * Description
 * Copyright (c) 2018
 *
 * @author HiCooper
 * @version 1.0
 * @date 2018/12/11 17:52
 */
@Component
public class DirectQueueReceiver {


    private static Random random =new Random();

    @RabbitListener(queues = "directA")
    @RabbitHandler
    public void directA(String msg) throws InterruptedException {
        System.out.println("directA:" + msg);
        Thread.sleep(random.nextInt(10000));
    }

    @RabbitListener(queues = "directB")
    @RabbitHandler
    public void directB(String msg) throws InterruptedException {
        System.out.println("directB:" + msg);
        Thread.sleep(random.nextInt(10000));
    }
}
