package com.luffy.juc.CASDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luffy
 * @version 1.0
 * @desc CAS
 * @date 2021/4/7 13:20
 */
public class CASdEMO
{



    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(1,2);
        System.out.println(atomicInteger.get());

    }
}
