package com.luffy.juc.functionInterface;

import java.util.function.Function;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/1 13:53
 */
public class functionDemo {
    public static void main(String[] args) {
        Function function = new Function<String,String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };
        Function<String,String> function1 = (o)->{return o;};
        System.out.println(function.apply("1111"));
    }
}
