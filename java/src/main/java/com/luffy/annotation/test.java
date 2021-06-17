package com.luffy.annotation;

import java.lang.annotation.*;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/25 16:11
 */
@myAnnnotetion
public class test {
    @myAnnnotetion
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

//注解可以在什么地方使用
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)  //注解在什么地方有效
@Documented  //是否将注解声称在javadoc中
@Inherited //子类可以继承父类的注解
@interface myAnnnotetion{

}
