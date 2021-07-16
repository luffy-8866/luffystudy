package com.luffy.spring.model;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/7/14 16:22
 */

public class User {

    String id;
    String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
