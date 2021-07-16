package com.luffy.Reflection;

import java.lang.annotation.*;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/6/17 14:49
 */
public class test注解 {
    public static void main(String[] args) throws ClassNotFoundException {
        Object o = new Object();
        Class<?> aClass = Class.forName("com.luffy.Reflection.Luffy");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface AnnoLuffy{
    String value();
}

@AnnoLuffy("db_luffy")
class Luffy{
    private int id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Luffy{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Luffy(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Luffy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
