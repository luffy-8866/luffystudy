package com.luffy.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luffy
 * @version 1.0
 * @desc 动态创建对象
 * @date 2021/6/11 16:03
 */
public class dynamicCreateClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.luffy.Reflection.luffy");
        //构造一个对象
//        luffy o = (luffy)aClass.newInstance();//本质调用无参构造器
//        System.out.println(o.toString());
//        //通过构造器创建对象
//        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
//        luffy luffy = (luffy)declaredConstructor.newInstance("luffy", 20, 20);
//        System.out.println(luffy);
        //通过反射调用普通方法
        luffy luffy = (luffy)aClass.newInstance();
        //通过反射获取一个方法
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(luffy, "luffy");
        System.out.println(luffy);
        //通过反射操作属性
        luffy luffy2 = (luffy)aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭安全检测
        name.setAccessible(true);
        name.set(luffy2,"luffy");
        System.out.println(luffy2);




    }
}
