package com.luffy.Reflection;

/**
 * @author luffy
 * @version 1.0
 * @desc 系统类的加载器
 * @date 2021/6/4 14:28
 */
public class test系统加载器 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器，  扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器，  跟加载器  C++
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

               ClassLoader classLoader = Class.forName("com.luffy.Reflection.test系统加载器").getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
