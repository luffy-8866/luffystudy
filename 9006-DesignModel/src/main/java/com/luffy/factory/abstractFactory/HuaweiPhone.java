package com.luffy.factory.abstractFactory;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 13:42
 */
public class HuaweiPhone implements MobileProduct {
    @Override
    public void start() {
        System.out.println("开华为手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为手机");

    }

    @Override
    public void callUp() {
        System.out.println("华为手机打电话");

    }

    @Override
    public void sendSMS() {
        System.out.println("华为手机发短信");

    }
}
