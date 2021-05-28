package com.luffy.builder;

import java.lang.management.BufferPoolMXBean;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 14:23
 */
public class Worker extends Builder {

    private House house;
    public Worker(){
        house=new House();
    }

    @Override
    void buildA(){
        house.setBuildeA("A");
        System.out.println("A");
    }

    @Override
    void buildB() {
        house.setBuildeB("B");
        System.out.println("B");

    }

    @Override
    void buildC() {
        house.setBuildeC("C");
        System.out.println("C");

    }

    @Override
    void buildD() {
        house.setBuildeD("D");
        System.out.println("D");

    }

    @Override
    House getHouse() {
        return house;
    }
}
