package com.luffy.prototype;


import java.util.Date;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/5/21 15:28
 */
public class Video implements Cloneable{
    private String name;
    private Date time;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //深克隆 解决问题
        Video clone = (Video)super.clone();
        clone.time = (Date)this.time.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public Video(String name, Date time) {
        this.name = name;
        this.time = time;
    }

    public Video() {
    }
}
