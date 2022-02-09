package com.luffy.data.pojo;

import javax.persistence.*;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/24 14:01
 */
@Entity
@Table(name = "user")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  自增主键mysql
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)  序列 oracle
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
