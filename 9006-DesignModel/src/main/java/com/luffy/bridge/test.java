package com.luffy.bridge;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/24 10:48
 */
public class test {

    public static void main(String[] args) {
        Computer computer =new Laptop(new Apple());
        Computer computer2 =new Desktop(new Lenovo());
        computer.info();
        computer2.info();

    }
}
