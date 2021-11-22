package com.luffy.spring.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/11/4 13:38
 */
@Component
public class test {
    @Scheduled(cron="0/5 * *  * * ? ")
    public void test(){
        System.out.println(11111);
    }
}
