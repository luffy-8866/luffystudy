package com.luffy.adapter;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 16:18
 */
public class Adapter extends Adaptee implements NetToUsb{
    @Override
    public void handleRequest() {
        super.request();
    }
}
