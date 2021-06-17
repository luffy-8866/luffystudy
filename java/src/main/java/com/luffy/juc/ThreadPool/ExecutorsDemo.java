package com.luffy.juc.ThreadPool;

import jdk.internal.org.objectweb.asm.tree.TableSwitchInsnNode;

import java.util.concurrent.*;

/**
 * @author luffy
 * @version 1.0
 * @desc executors 三大方法
 * @date 2021/3/31 17:02
 */
public class ExecutorsDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5),
                new ThreadPoolExecutor.AbortPolicy());

        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//固定数量线程池
//        ExecutorService threadPool = Executors.newCachedThreadPool();//男子汉大丈夫线程池，可伸可屈
        try{
            for (int i = 0; i < 100; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() +"++++++++");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
