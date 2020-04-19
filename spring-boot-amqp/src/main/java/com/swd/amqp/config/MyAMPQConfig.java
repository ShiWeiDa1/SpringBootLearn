package com.swd.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author swd
 */
@Configuration
public class MyAMPQConfig {
    @Bean
    public MessageConverter messageConverter() {
        System.out.println("messageConverter...");
        return new Jackson2JsonMessageConverter();
    }
}
