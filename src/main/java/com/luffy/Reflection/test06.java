package com.luffy.Reflection;

/**
 * @author luffy
 * @version 1.0
 * @desc 测试类进行初始化的时间
 * @date 2021/6/3 21:44
 */
public class test06 {
    static{
        System.out.println("main被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
//        son son = new son();
        //反射也会产生主动引用
//        Class.forName("com.luffy.Reflection.son");

        //被动引用 不会产生类的引用
        System.out.println(son.b);
        son[] sons = new son[5];
        System.out.println(son.M);




    }

}

class father{
    static int b=2;
    static {
        System.out.println("弗雷被继承");
    }

}
class son extends father{
    static {
        System.out.println("子类被加载");
        m=300;
    }
    static int m=100;
    static final int M=1;

}
