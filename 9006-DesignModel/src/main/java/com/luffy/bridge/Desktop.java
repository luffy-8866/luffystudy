package com.luffy.bridge;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/24 10:46
 */
public class Desktop extends Computer {

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("台式机");
    }
}

class Laptop extends Computer {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("平板");
    }
}
