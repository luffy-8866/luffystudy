package com.luffy.juc.functionInterface;

import java.util.function.Consumer;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/1 14:09
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer consumer2=(s)->{
            System.out.println(s);
        };
        consumer.accept("ssssssss");
    }
}
