package com.berry.springbootrebbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 模式匹配，广播和直连 三种 交换器队列
 * 绑定配置
 * @author HiCooper
 * @version 1.0
 * @date 2018/7/12 17:28
 */
@Configuration
public class RabbitConfig {


    // ------------------------------------ 模式匹配 ------------------------------------

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

    @Bean
    public Queue topicA() {
        return new Queue("topicA", true, false, false);
    }

    @Bean
    public Queue topicB() {
        return new Queue("topicB", true, false, false);
    }

    /**
     * 将 topicA 队列绑定到交互器exchange，并且定义路由匹配规则为 topic.#
     * 路由key为 "topic.#"
     *
     * @param topicA
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeTopicA(Queue topicA, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicA).to(topicExchange).with("topic.#");
    }

    /**
     * 路由key为 "topic.b"
     * @param topicB
     * @param topicExchange
     * @return
     */
    @Bean
    Binding bindingExchangeTopicB(Queue topicB, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicB).to(topicExchange).with("topic.b");
    }


    // ------------------------------------ 完全匹配(直连) ------------------------------------

    /**
     * 定义一个完全匹配交换器
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue directA() {
        return new Queue("directA",false,false,true);
    }

    @Bean
    public Queue directB() {
        return new Queue("directB",false,false,true);
    }

    @Bean
    Binding bindingExchangeDirectA(Queue directA, DirectExchange directExchange) {
        return BindingBuilder.bind(directA).to(directExchange).with("directA");
    }

    @Bean
    Binding bindingExchangeDirectB(Queue directB, DirectExchange directExchange) {
        return BindingBuilder.bind(directB).to(directExchange).with("directB");
    }


    // ------------------------------------ 消息广播 ------------------------------------

    /**
     * 定义一个消息广播交换器
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Queue fanoutA() {
        return new Queue("fanoutA",false,false,true);
    }

    @Bean
    public Queue fanoutB() {
        return new Queue("fanoutB",false,false,true);
    }

    @Bean
    Binding bindingFanoutExchangeFanoutA(Queue fanoutA,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutA).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeFanoutB(Queue fanoutB,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutB).to(fanoutExchange);
    }

}
