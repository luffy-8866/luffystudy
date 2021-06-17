package com.luffy.juc;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author luffy
 * @version 1.0
 * @desc 同步队列
 * @date 2021/3/31 16:46
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue();
        new Thread(()->{
            try {
            System.out.println(Thread.currentThread().getName()+"put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+queue.take());
                TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName()+queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
