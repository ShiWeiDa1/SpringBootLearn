package com.swd.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author swd
 */
@Configuration
@ConditionalOnWebApplication    //web应用才生效
@EnableConfigurationProperties(HelloServiceProperties.class)
public class HelloServiceAutoConfigration {

    @Autowired
    HelloServiceProperties helloServiceProperties;

    @Bean
    public HelloService helloService() {
        HelloService service = new HelloService();
        service.setHelloServiceProperties(helloServiceProperties);
        return service;
    }

}
