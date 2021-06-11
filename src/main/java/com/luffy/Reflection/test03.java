package com.luffy.Reflection;

import java.lang.annotation.ElementType;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * @author luffy
 * @version 1.0
 * @desc 所有类型的class
 * @date 2021/6/2 16:44
 */
public class test03 {
    public static void main(String[] args) {
        Class<Object> objectClass = Object.class;//类
        Class<Comparable> comparableClass = Comparable.class; //接口
        Class<String[]> aClass = String[].class;//数组
        Class<int[][]> aClass1 = int[][].class;//二位数组
        Class<Override> overrideClass = Override.class;//注解
        Class<ElementType> elementTypeClass = ElementType.class;//枚举
        Class<Integer> integerClass = Integer.class; //基本数据类型
        Class<Void> voidClass = void.class;//void


    }
}
