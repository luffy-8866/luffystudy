package com.luffy.factory.abstractFactory;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 13:42
 */
public class MIPhone implements MobileProduct {
    @Override
    public void start() {
        System.out.println("开启米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭米手机");

    }

    @Override
    public void callUp() {
        System.out.println("米手机打电话");

    }

    @Override
    public void sendSMS() {
        System.out.println("米手机发短信");

    }
}
