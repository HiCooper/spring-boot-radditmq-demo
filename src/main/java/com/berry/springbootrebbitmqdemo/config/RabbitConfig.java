package com.berry.springbootrebbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
        return new Queue("hello");
    }

    @Bean
    public Queue queueSingle() {
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMuch() {
        return new Queue("topic.messages");
    }


    /**
     * 定义一个模式匹配交换器
     * type=topic
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 将queueSingle队列绑定到交互器exchange，并且定义路由规则为 topic.single
     * 即 路由key为 "topic.single"
     * @param queueSingle
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeSingleQueue(Queue queueSingle, TopicExchange exchange) {
        return BindingBuilder.bind(queueSingle).to(exchange).with("topic.single");
    }

    /**
     * 将queueMuch队列绑定到交互器exchange，并且定义路由规则为 topic.#
     * 即 路由key 以"topic."开头
     * @param queueMuch
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMuchQueue(Queue queueMuch, TopicExchange exchange) {
        //#通配符
        return BindingBuilder.bind(queueMuch).to(exchange).with("topic.#");
    }

}
