package com.berry.springbootrebbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/13 13:02
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloQueueReceiver {

    private static Random random =new Random();

    @RabbitHandler
    public void process(String msg) throws InterruptedException {
        System.out.println("HelloQueueReceiver:" + msg);
        Thread.sleep(random.nextInt(10000));
    }

}
