package com.berry.springbootrebbitmqdemo.api;

import com.berry.springbootrebbitmqdemo.service.FanoutSender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/13 12:55
 */
@RestController
@RequestMapping("test")
public class TestSender {

    @Autowired
    private FanoutSender fanoutSender;


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/send1")
    public String  topicSend1() {
//        topicSend1String context = "my topic 1";
//        System.out.println("发送者说 : " + context);
//        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
        String context = "hi, fanout msg ";
        fanoutSender.send(context);
        return context;
    }
    @RequestMapping("/send2")
    public String topicSend2() {
        String context = "my topic 2";
        System.out.println("发送者说 : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
        return  context;
    }
}
