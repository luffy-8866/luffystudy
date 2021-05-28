package com.luffy.factory.abstractFactory;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 13:50
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("小米");
        MIFactory miFactory = new MIFactory();
        MobileProduct mobileProduct = miFactory.mobileProduct();
        mobileProduct.callUp();
        mobileProduct.shutdown();

        RouterProduct routerProduct = miFactory.routerProduct();
        routerProduct.openWifi();
        routerProduct.shutdown();

        System.out.println("华为");
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        MobileProduct mobileProduct1 = huaweiFactory.mobileProduct();
        RouterProduct routerProduct1 = huaweiFactory.routerProduct();
        mobileProduct1.shutdown();
        routerProduct1.shutdown();
    }
}
