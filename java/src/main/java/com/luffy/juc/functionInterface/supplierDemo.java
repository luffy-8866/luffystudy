package com.luffy.juc.functionInterface;

import java.util.function.Supplier;

/**
 * @author luffy
 * @version 1.0
 * @desc 供给型接口
 * @date 2021/4/1 14:28
 */
public class supplierDemo {
    public static void main(String[] args) {
        Supplier supplier =new Supplier() {
            @Override
            public Object get() {
                return 1024;
            }
        };
        Supplier supplier1 = ()->{return 1024;};
        System.out.println(supplier.get());
    }
}
