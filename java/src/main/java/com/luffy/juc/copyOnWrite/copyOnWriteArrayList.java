package com.luffy.juc.copyOnWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/25 13:34
 *
 * java.util.ConcurrentModificationException
 */
public class copyOnWriteArrayList {
    public static void main(String[] args) {
//        List<String> objects = new ArrayList<>();
//        List<String> objects = new Vector<>();
        List<String> objects = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                objects.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(objects.toString());
            },String.valueOf(i)).start();
        }
    }
}
