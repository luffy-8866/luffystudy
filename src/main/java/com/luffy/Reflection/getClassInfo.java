package com.luffy.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author luffy
 * @version 1.0
 * @desc 获得类的信息
 * @date 2021/6/11 15:25
 */
public class getClassInfo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.luffy.Reflection.luffy");

        System.out.println("baoming+类名"+aClass.getName());
        System.out.println("类名"+aClass.getSimpleName());
        System.out.println("类的属性" + aClass.getFields().toString());//只能找到public属性
        Field[] declaredFields = aClass.getDeclaredFields();//找到全部属性
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
//        System.out.println("指定public属性的值,没有会报错"+aClass.getField("name"));
        System.out.println("指定属性的值"+aClass.getDeclaredField("name"));
        System.out.println("=============获得类的方法=================");
        for (Method method : aClass.getMethods()) {
            System.out.println("获得本类机器父类的全部public方法"+method);
        }
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.println("获得本类的所有方法"+declaredMethod);
        }
        System.out.println("=============获得指定方法=================");
        System.out.println(aClass.getMethod("getName", null));
        System.out.println(aClass.getMethod("setName", String.class));
        System.out.println("=============获得指定构造器=================");
        for (Constructor<?> constructor : aClass.getConstructors()) {
            System.out.println(constructor);
        }
        for (Constructor<?> constructor : aClass.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
        System.out.println(aClass.getDeclaredConstructor(String.class, int.class, int.class));


    }
}
