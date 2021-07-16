package com.luffy.juc.count;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author luffy
 * @version 1.0
 * @desc 信号量
 * @date 2021/3/27 13:15
 */
public class semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

}
