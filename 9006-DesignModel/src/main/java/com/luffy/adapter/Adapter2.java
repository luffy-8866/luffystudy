package com.luffy.adapter;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 16:18
 */
public class Adapter2 implements NetToUsb{

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
