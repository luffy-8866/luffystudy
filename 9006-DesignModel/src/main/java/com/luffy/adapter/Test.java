package com.luffy.adapter;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 16:19
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter2 adapter = new Adapter2(adaptee);
        adapter.handleRequest();
    }
}
