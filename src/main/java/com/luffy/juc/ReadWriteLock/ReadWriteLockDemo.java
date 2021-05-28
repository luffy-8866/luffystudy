package com.luffy.juc.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luffy
 * @version 1.0
 * @desc 读写锁
 * @date 2021/3/27 13:47
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {


    }
}
/***
 自定义缓存
 */
class MyCache{
    private volatile Map<String,Object> map =new HashMap<>();
    public ReadWriteLock lock = new ReentrantReadWriteLock();
    public void test(){
        lock.readLock().lock();
        lock.writeLock().lock();
    }
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"开始写入");
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入ok");
    }
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"开始duqu");
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"duquok");
    }

}