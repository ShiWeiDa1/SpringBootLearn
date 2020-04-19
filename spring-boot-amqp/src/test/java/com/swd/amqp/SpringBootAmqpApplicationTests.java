package com.swd.amqp;

import com.rabbitmq.client.AMQP;
import com.swd.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 使用编码方式创建exchange和Queue,并绑定制定的路由键和队列
     */
    @Test
    public void createExchange() {
        //创建一个directExchanger(点对点)
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));

        //创建一个名字为amqpAdmin.news的队列
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue", true));

        //绑定exchange和Queue
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",
                Binding.DestinationType.QUEUE,
                "amqpAdmin.exchange",
                "amqp.hello",
                null));


    }

    /**
     * 1.单播(点对点)
     */
    @Test
    public void contextLoads() {
        //需要自己构造message;定义消息内容和消息头
        //rabbitTemplate.send(AMQP.Exchange,routeKey,message);

        //object默认当成消息体,只需要传入发送的对象,自动序列化发给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        /*
        //将数据封装成map类型的集合
        Map<String,Object> map = new HashMap<>();
        map.put("msg","first data");
        map.put("data", Arrays.asList("zhangsan",999,"数据"));
        //对象被默认序列化之后被发送出去
        rabbitTemplate.convertAndSend("exchange.direct","swd.news",map);
        */
        //注入新的对象的序列化机制,使用Jackson2JsonMessageConverter来进行序列化参见MyAMPQConfig.java
        rabbitTemplate.convertAndSend("exchange.direct", "swd.news", new Book("西游记", "吴承恩"));


    }

    /**
     * 一次发送的消息只能接收一次,否则会出现NullPointerException异常
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("swd.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 测试广播
     */
    @Test
    public void sendMsg() {
        System.out.println(
                "sendMsg..."
        );
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
    }

}
