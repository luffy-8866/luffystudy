package com.luffy.juc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2022/1/14 9:51
 */
public class threadTest {

    public static void main(String[] args) {
        second(1000000);
    }
        public static final void second(long seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
            }
        }

}
