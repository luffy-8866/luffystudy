package com.luffy.juc.copyOnWrite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/25 13:34
 *
 * java.util.ConcurrentModificationException
 */
public class copyOnWriteArraySet {
    public static void main(String[] args) {
        Set<String> objects = new HashSet<>();
//        List<String> objects = new Vector<>();
//        Set<String> objects = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                objects.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(objects.toString());
            },String.valueOf(i)).start();
        }
    }
}
