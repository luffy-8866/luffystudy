package com.luffy.juc;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/24 13:48
 */
public class lockPriCon {
    public static void main(String[] args) {
        B a = new B();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                a.indirec();
            }},"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                a.indirec();
            }},"C").start();
        new Thread(()->{for (int i = 0; i < 10; i++) {
            a.consumer();
        }},"B").start();
        new Thread(()->{for (int i = 0; i < 10; i++) {
            a.consumer();
        }},"D").start();
    }

}
class B {
     private Lock lock = new ReentrantLock();
      private Condition condition = lock.newCondition();
    int number= 0;
    public    void indirec(){
        lock.lock();
        try {
            while(number!=0) {
                condition.await();
            }
            number++;
            System.out.println("+++++++++++"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public    void consumer(){
        lock.lock();
        try {
            while(number==0) {
                condition.await();

            }
            number--;
            System.out.println("-----------"+number);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

