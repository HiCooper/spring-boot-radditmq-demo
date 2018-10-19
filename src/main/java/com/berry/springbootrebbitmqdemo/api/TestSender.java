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


    @GetMapping("/topicExchange")
    public void topicSend2(@RequestParam(name = "message") String message) {
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.single", message);
    }
}
