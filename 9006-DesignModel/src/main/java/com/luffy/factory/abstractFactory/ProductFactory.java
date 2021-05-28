package com.luffy.factory.abstractFactory;

/**
 * @author luffy
 * @version 1.0
 * @desc 抽象产品工厂
 * @date 2021/5/21 13:46
 */

public interface ProductFactory {
    MobileProduct mobileProduct();

    RouterProduct routerProduct();
}
