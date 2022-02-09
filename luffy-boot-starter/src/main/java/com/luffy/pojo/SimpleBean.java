package com.luffy.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2022/1/6 10:24
 */
@EnableConfigurationProperties(SimpleBean.class)
@ConfigurationProperties(prefix = "simplebean")
public class SimpleBean {

    private String id;
    private String name;

    public SimpleBean() {
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
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

    public SimpleBean(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
