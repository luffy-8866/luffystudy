package com.luffy.juc.thread;

import javax.swing.plaf.TableHeaderUI;

/**
 * @author luffy
 * @version 1.0
 * @desc 时Java虚拟机中已经没有非Daemon线程，虚拟机需要退出。Java虚拟机中的所有Daemon线程都需要立即
 *          终止，因此DaemonRunner立即终止，但是DaemonRunner中的finally块并没有执行。
 * @date 2022/1/14 10:24
 */
public class Daemon {

        public static void main(String[] args) {
            Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
            thread.setDaemon(true);//守护线程
            thread.start();
        }
        static class DaemonRunner implements Runnable {
            @Override
            public void run() {
                try {
                        Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
            }finally {
                    System.out.println("DaemonThread finally run.");
                }
            }
        }
}
