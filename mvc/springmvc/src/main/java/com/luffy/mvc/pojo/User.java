package com.luffy.mvc.pojo;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/12/9 14:55
 */
public class User {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }
}
