package com.luffy.spring.proxy;

import com.luffy.spring.service.UserDao;
import com.luffy.spring.service.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/7/14 16:26
 */
public class JdkProxy {
    public static void main(String[] args) {

        UserDao o = (UserDao)Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), new Class[]{UserDao.class}, new UserDaoProxy());
        o.add(1,1);
    }
}


class UserDaoProxy implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"---------"+args.toString());
        Object invoke = method.invoke(new UserDaoImpl(), args);

        System.out.println(invoke);

        return invoke;
    }
}