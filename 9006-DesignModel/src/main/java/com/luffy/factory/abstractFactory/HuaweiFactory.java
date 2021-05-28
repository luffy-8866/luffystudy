package com.luffy.factory.abstractFactory;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 13:47
 */
public class HuaweiFactory implements ProductFactory {
    @Override
    public MobileProduct mobileProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
