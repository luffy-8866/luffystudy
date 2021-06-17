package com.luffy.juc.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/26 10:35
 * 计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();//等待计数器归零，在执行下面的
        System.out.println("close");
    }

}
