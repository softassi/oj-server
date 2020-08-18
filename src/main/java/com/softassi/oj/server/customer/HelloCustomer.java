package com.softassi.oj.server.customer;

import com.softassi.oj.server.dto.TagDto;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : HelloCustomer
 * @Description :
 * @Author : cybersa
 * @Date: 2020-08-18 19:28
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloCustomer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("message:" + message);
    }

    @RabbitHandler
    public void receive2(TagDto tagDto) {
        System.out.println("message:" + tagDto);
    }
}
