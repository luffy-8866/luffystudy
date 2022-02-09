package com.luffy.config;

import com.luffy.pojo.SimpleBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2022/1/6 10:29
 */

@Configuration
@ConditionalOnClass
public class MyAutoConfiguration {

    static{
        System.out.println("MyAutoConfiguration init.....");
    }

    @Bean
    public SimpleBean simpleBean(){
        return new SimpleBean();
    }


}
