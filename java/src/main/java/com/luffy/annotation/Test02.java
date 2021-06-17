package com.luffy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/28 10:12
 */
public class Test02 {
    //注解可以显示赋值，如果没有默认值，注解必须赋值参数
    @luffyAnnotation(schools = {"山西大学"},name = "luffy")
    public void test(){

    }
    @luffyAnnotation2("luffy")
    public void test2(){

    }

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface luffyAnnotation{
    //注解参数 参数类型+参数名（）；
    String name() default "";
    int age() default 0;
    int id() default -1;//-1代表不存在

    String[] schools();
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface luffyAnnotation2{

    String value();

        }
