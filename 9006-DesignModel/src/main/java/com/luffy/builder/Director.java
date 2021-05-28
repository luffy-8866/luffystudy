package com.luffy.builder;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 14:37
 */
public class Director {

    public House build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return builder.getHouse();
    }

    public static void main(String[] args) {
        Director director = new Director();
        House build = director.build(new Worker());
        System.out.println(build.toString());
    }
}
