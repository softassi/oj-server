package com.softassi.oj.server.customer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : HelloCustomer
 * @Description :
 * @Author : cybersa
 * @Date: 2020-08-18 19:28
 */
@Component
public class RouteCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                          exchange = @Exchange(value = "directs", type = "direct"),
                          key = {"info", "error", "warn"})
    })
    public void receive1(String message) {
        System.out.println("message1:" + message);

    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "directs", type = "direct"),
                    key = {"error"})
    })
    public void receive2(String message) {
        System.out.println("message2:" + message);

    }
}
