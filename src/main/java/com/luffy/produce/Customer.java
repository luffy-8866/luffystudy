package com.luffy.produce;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/5 15:39
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "true"))
public class Customer {

    @RabbitHandler
    public void message(String message){
        System.out.println("message = " + message);
    }
}
