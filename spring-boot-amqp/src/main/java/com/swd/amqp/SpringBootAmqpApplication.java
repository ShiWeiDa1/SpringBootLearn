package com.swd.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 *  1.RabbitAutoConfiguration
 *  2.有自动配置的连接工厂CachingConnectionFactory
 *  3.RabbitProperties 封装了RabbitMQ的配置
 *  4.RabbitTemplate    给RabbitMQ发送和接受消息
 *  5.AmqpAdmin:RabbitMQ系统管理功能组件
 *
 *  @author swd
 * @EnableRabbit 开启基于注解的RabbitMQ模式
 * @EnableRabbit +@RabbitListener 监听消息队列的内容
 */
@EnableRabbit
@SpringBootApplication
public class SpringBootAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class, args);
    }

}
