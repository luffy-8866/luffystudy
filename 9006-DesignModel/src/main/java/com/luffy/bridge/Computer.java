package com.luffy.bridge;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/24 10:44
 */
public abstract class Computer {

    protected Brand brand;

    public Computer() {
    }

    public Computer(Brand brand) {
        this.brand = brand;
    }
    public void info(){
        brand.info();
    }
}
