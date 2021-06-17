package com.luffy.juc.count;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/26 10:35
 * 计数器
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("成功调用线程");
        });

        for (int i = 0; i < 7; i++) {
            final  int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"+++++"+String.valueOf(temp));
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
