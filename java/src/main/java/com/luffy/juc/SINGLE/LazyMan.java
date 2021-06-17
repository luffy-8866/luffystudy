package com.luffy.juc.SINGLE;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author luffy
 * @version 1.0
 * @desc 懒汉式单例模式
 * @date 2021/4/12 15:13
 */
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private static LazyMan lazyMan;
    //双重锁机制  DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan == null){
            synchronized (LazyMan.class){
                if (lazyMan == null){
                    lazyMan= new LazyMan();
                }
            }
        }

        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(LazyMan.getInstance());
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan = declaredConstructor.newInstance();
        System.out.println(lazyMan);
    }
}
