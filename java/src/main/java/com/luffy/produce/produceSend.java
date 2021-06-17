package com.luffy.produce;

import com.luffy.util.RabbitMQUtils;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/2/26 13:58
 */
public class produceSend {

    @Test
    public void produceSend() throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        /**
         * 参数1 队列姓名
         *队列是否需要持久化 true持久
         * exclusive 是否独占队列 true独占队列
         * autoDelete 是否消费完成后自动删除队列  true删除
         * 附加参数
         */
        channel.queueDeclare("hello",false,false,false,null);
        channel.basicPublish("","hello",null,"hello shabi".getBytes());

        RabbitMQUtils.close(channel,connection);
    }
    @Test
    public void consumer() throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        /**
         * 参数1 队列姓名
         *队列是否需要持久化 true持久
         * exclusive 是否独占队列 true独占队列
         * autoDelete 是否消费完成后自动删除队列  true删除
         * 附加参数
         */
        channel.queueDeclare("hello",false,false,false,null);
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(" = " + new String(body));

            }
        });

        RabbitMQUtils.close(channel,connection);
    }
}
