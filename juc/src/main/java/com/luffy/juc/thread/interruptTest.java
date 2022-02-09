package com.luffy.juc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2022/1/14 10:57
 */
public class interruptTest {
        public static void main(String[] args) throws Exception {
// sleepThread不停的尝试睡眠
            Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
            sleepThread.setDaemon(true);
// busyThread不停的运行
            Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
            busyThread.setDaemon(true);
            sleepThread.start();
            busyThread.start();
// 休眠5秒，让sleepThread和busyThread充分运行
            TimeUnit.SECONDS.sleep(5);
            sleepThread.interrupt();
            busyThread.interrupt();
            System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
            System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
// 防止sleepThread和busyThread立刻退出
            TimeUnit.SECONDS.sleep(5);
        }
        static class SleepRunner implements Runnable {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        static class BusyRunner implements Runnable {
            @Override
            public void run() {
                while (true) {
                }
            }
        }
    }

