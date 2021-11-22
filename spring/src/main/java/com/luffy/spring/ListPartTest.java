package com.luffy.spring;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/11/15 10:00
 */
public class ListPartTest {

    private static final List<String> OLD_LIST = Arrays.asList(
            "唐僧,悟空,八戒,沙僧,曹操,刘备,孙权".split(","));

    public static void main(String[] args) {
        // 集合分片
        List<List<String>> newList = Lists.partition(OLD_LIST, 1);
        // 打印分片集合
        newList.forEach(i -> {
            System.out.println("集合长度：" + i.size());
        });
    }
}
