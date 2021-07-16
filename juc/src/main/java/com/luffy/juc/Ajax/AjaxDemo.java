package com.luffy.juc.Ajax;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author luffy
 * @version 1.0
 * @desc  异步调用 Future
 * @date 2021/4/6 14:42
 */
public class AjaxDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没返回值
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("66666666");
        });
        //有返回值
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(()->{
            System.out.println("66666666");
            return 1024;
        });
        System.out.println(supplyAsync.get());
        future.get();
    }
}
