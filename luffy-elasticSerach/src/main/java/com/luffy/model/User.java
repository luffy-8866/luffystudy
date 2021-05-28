package com.luffy.model;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/28 15:43
 */
public class User {
    private String name;
    private String sex;
    private String age;

    public User() {
    }

    public User(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
