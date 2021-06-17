package com.luffy.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/26 10:22
 */
public class callableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        myThread myThread = new myThread();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(myThread);
        new Thread(integerFutureTask,"A").start();
        new Thread(integerFutureTask,"VB").start();//结果有缓存，多次调用
        //返回值在futuer
        System.out.println((Integer)integerFutureTask.get());//返回值可能会造成阻塞，如果线程内程序花费时间较长，一直不返回返回值。
    }
}

class myThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("++++++++");
        return 1024;
    }
}
