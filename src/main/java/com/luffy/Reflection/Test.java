package com.luffy.Reflection;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/28 11:00
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> luffy = Class.forName("com.luffy.Reflection.luffy");
        Class<?> luffy2 = Class.forName("com.luffy.Reflection.luffy");
        Class<?> luffy3 = Class.forName("com.luffy.Reflection.luffy");
        //一个类只有一个class对象
        //被加载后整个类都会被封装到class对象中
        System.out.println(luffy.hashCode());
        System.out.println(luffy2.hashCode());
        System.out.println(luffy3.hashCode());
    }

}

class luffy{

    private String name;
    private int id;
    private int age;

    public luffy() {
    }

    public luffy(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "luffy{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    private void settt(int age) {
        this.age = age;
    }
}
