package com.berry.springbootrebbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 模式匹配交换器队列绑定的队列接收器
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/13 13:02
 */
@Component
public class TopicQueueReceiver {

    private static Random random =new Random();

    @RabbitListener(queues = "topicA")
    @RabbitHandler
    public void topicA(String msg) throws InterruptedException {
        System.out.println("topicA:" + msg);
        Thread.sleep(random.nextInt(10000));
    }

    @RabbitListener(queues = "topicB")
    @RabbitHandler
    public void topicB(String msg) throws InterruptedException {
        System.out.println("topicB:" + msg);
        Thread.sleep(random.nextInt(10000));
    }

}
