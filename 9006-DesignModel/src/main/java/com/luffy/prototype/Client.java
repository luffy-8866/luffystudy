package com.luffy.prototype;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Date;

/**
 * @author luffy
 * @version 1.0
 * @desc 原型模式 （浅克隆）
 * @date 2021/5/21 15:31
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Video video = new Video("luffy",date);
        Video clone = (Video)video.clone();

        System.out.println(video.toString());
        System.out.println(clone.toString());
        date.setTime(26545646);
        System.out.println(video.toString());
        System.out.println(clone.toString());
//        System.out.println("1111111111111111111111");
//        Video clone = (Video)video.clone();
//
//        System.out.println(clone);
//        System.out.println(clone.hashCode());

    }
}
