//package com.luffy.securityoauth2.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * @author luffy
// * @version 1.0
// * @desc
// * @date 2021/4/16 16:35
// */
//@Configuration
//public class RedisConfig {
//
//
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public TokenStore  redisTokenStore(){
//        return new RedisTokenStore(redisConnectionFactory);
//    }
//
//}
