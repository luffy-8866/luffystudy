package com.luffy.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/3/31 16:12
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<>(3);
        objects.offer("1");
    }
}
