package com.luffy.factory.abstractFactory;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 13:44
 */
public class MIRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("开启小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");

    }

    @Override
    public void openWifi() {
        System.out.println("打开wifi");

    }

    @Override
    public void setting() {
        System.out.println("设置小米路由器");

    }
}
