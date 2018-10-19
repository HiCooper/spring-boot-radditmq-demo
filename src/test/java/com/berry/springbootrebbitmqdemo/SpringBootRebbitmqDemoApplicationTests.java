package com.berry.springbootrebbitmqdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRebbitmqDemoApplicationTests {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void testQueue(){
        for (int i = 0; i < 10 ; i++) {
            this.rabbitTemplate.convertAndSend("topicExchange", "topic.single", "hello"+i);
        }
    }

}
