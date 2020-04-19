package com.swd.amqp.service;

import com.swd.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author regan
 * @data 2019/8/15
 */
@Service
public class BookService {

    @RabbitListener(queues = "swd.news")
    public void receive(Book book) {
        System.out.println("收到消息:" + book);

    }

    @RabbitListener(queues = "xxx.news")
    public void receive(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
