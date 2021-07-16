package com.luffy.spring.service;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/7/14 16:24
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
