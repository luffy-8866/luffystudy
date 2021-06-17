package com.luffy.juc.SINGLE;

/**
 * @author luffy
 * @version 1.0
 * @desc 饿汉式单例模式
 * @date 2021/4/7 10:48
 */
public class Hungry {
    private Hungry(){

    }
    private final static Hungry HUNGRY=new Hungry();
    public static Hungry getInstance(){
        return HUNGRY;
    }
}
