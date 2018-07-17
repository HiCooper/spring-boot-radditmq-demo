package com.berry.springbootrebbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
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
        return new Queue("hello",false,false,true);
    }

    @Bean
    public Queue queueSingle() {
        return new Queue("topic.message",false,false,true);
    }

    @Bean
    public Queue queueMuch() {
        return new Queue("topic.messages",false,false,true);
    }


    /**
     * 定义一个模式匹配交换器
     * type=topic
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 定义一个完全匹配交换器
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    /**
     * 定义一个消息广播交换器
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将hello对列绑定到Fanout交换器
     * @param helloQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeHelloQueue(Queue helloQueue,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(helloQueue).to(fanoutExchange);
    }

    /**
     * 将single对列绑定到Fanout交换器
     * @param queueSingle
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingFanoutExchangeSingleQueue(Queue queueSingle,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueSingle).to(fanoutExchange);
    }

    /**
     * 将queueSingle队列绑定到交互器exchange，并且定义路由规则为 topic.single
     * 即 路由key为 "topic.single"
     * @param queueSingle
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeSingleQueue(Queue queueSingle, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueSingle).to(topicExchange).with("topic.single");
    }

    /**
     * 将queueMuch队列绑定到交互器exchange，并且定义路由规则为 topic.#
     * 即 路由key 以"topic."开头
     * @param queueMuch
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeMuchQueue(Queue queueMuch, TopicExchange topicExchange) {
        //#通配符
        return BindingBuilder.bind(queueMuch).to(topicExchange).with("topic.#");
    }

}
