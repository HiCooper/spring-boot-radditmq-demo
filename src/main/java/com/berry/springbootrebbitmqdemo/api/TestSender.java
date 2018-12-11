package com.berry.springbootrebbitmqdemo.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/13 12:55
 */
@RestController
@RequestMapping("test")
public class TestSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    /**
     * 模式匹配 能匹配到 topic.a 路由的队列
     */
    @GetMapping("/topicA")
    public void topicA() {
        System.out.println("这里只有topicA收到消息");
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.a", "test-message");
    }

    /**
     * 模式匹配 能匹配到 topic.b 路由的队列
     */
    @GetMapping("/topic")
    public void topic() {
        System.out.println("这里topicA 和 topicB 都应该收到消息");
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.b", "test-message");
    }

    /**
     * 广播 fanoutExchange 的所有队列
     */
    @GetMapping("/fanout")
    public void fanout() {
        System.out.println("这里fanoutA 和 fanoutB 都应该收到消息");
        this.rabbitTemplate.convertAndSend("fanoutExchange","","test-message");
    }

    /**
     * 直连 directExchange 的 A队列
     */
    @GetMapping("/directA")
    public void directA() {
        System.out.println("这里只有directA收到消息");
        this.rabbitTemplate.convertAndSend("directExchange","directA", "test-message");
    }

    /**
     * 直连 directExchange 的 B队列
     */
    @GetMapping("/directB")
    public void directB() {
        System.out.println("这里只有directB收到消息");
        this.rabbitTemplate.convertAndSend("directExchange","directB", "test-message");
    }
}
