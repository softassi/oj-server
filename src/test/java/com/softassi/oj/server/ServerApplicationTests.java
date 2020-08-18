package com.softassi.oj.server;

import com.softassi.oj.server.dto.TagDto;
import com.softassi.oj.server.util.JsonUtils;
import com.softassi.oj.server.util.UuidUtil;
import org.apache.catalina.Server;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ServerApplication.class)
class ServerApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
        // 发送给Heloo的队列
        TagDto tagDto = new TagDto();
        tagDto.setId(UuidUtil.getUuid());
        tagDto.setName("递归");
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("hello", tagDto);
        }
    }
    @Test
    void testWork() {
        // 发送给Heloo的队列
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "hello rabbitmq");
        }
    }
    @Test
    void tsetFanout() {
        // 发送给Heloo的队列
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("logs", "", "hello rabbitmq");
        }
    }
    @Test
    void testRoute() {
        // 发送给Heloo的队列
        rabbitTemplate.convertAndSend("directs", "error", "hello rabbitmq");
    }

    @Test
    void testTopic() {
        // 发送给Heloo的队列
        rabbitTemplate.convertAndSend("topics", "user.save", "hello rabbitmq");
    }

}
