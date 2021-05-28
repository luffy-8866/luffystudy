package com.luffy.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/2 16:12
 */
public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    static{
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/luffy");
        connectionFactory.setUsername("luffy");
        connectionFactory.setPassword("luffy");
    }
    public static Connection getConnection() throws IOException, TimeoutException {
        return connectionFactory.newConnection();
    }
    public static void close(Channel channel,Connection connection) throws IOException, TimeoutException {
        if (channel!=null){
            channel.close();
        }
        if (connection!=null){
            connection.close();
        }
    }


}
