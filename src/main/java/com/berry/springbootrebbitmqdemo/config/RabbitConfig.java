package com.berry.springbootrebbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/12 17:28
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue", true, false, false);
    }

    /**
     * 定义一个模式匹配交换器
     * type=topic
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 将queueSingle队列绑定到交互器exchange，并且定义路由规则为 topic.single
     * 即 路由key为 "topic.single"
     *
     * @param helloQueue
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeSingleQueue(Queue helloQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(helloQueue).to(topicExchange).with("topic.single");
    }

}
