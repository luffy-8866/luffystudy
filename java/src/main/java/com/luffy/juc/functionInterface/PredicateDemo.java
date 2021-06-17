package com.luffy.juc.functionInterface;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/1 13:53
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        Predicate<String> predicate1 = (s)->{return s.isEmpty();};
        System.out.println(predicate.test(""));
    }
}
