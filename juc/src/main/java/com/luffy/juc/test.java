package com.luffy.juc;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/22 17:06
 */
public class test {

    static int m1(int num){
        int x=0;
        for (int i=0;i<num;i++){
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        Phone a = new Phone();
//        new Thread(()->{a.msg();},"B").start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(()->{a.send();},"A").start();
        new Thread(()->{
            System.out.println(m1(1000));
        }).start();
        new Thread(()->{
            System.out.println("A"+m1(2000));
        }).start();

    }



}
class Phone{

    public static synchronized  void send(){
        System.out.println("send");
    }
    public synchronized void msg(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("msg");
    }
}