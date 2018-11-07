/*
 * @projectName jyplatform
 * @package com.antony.learn.async
 * @className com.antony.learn.async.CompletableFuture
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture
 *
 * @author wangqian
 * @version 1.0.0
 * @description TODO
 * @date 2018/11/7 14:30
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //会以守护线程的形式存在
        CompletableFuture<String> completableFuture = new CompletableFuture();

        //自己开个线程去执行 执行完把结果告诉completableFuture即可
        new Thread(() -> {
            // 模拟执行耗时任务
            System.out.println("task doing...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 告诉completableFuture任务已经完成 并且把结果告诉completableFuture
            completableFuture.complete("ok"); //这里把你信任的结果set进去后，所有阻塞的get()方法都能立马苏醒，获得到结果
        }).start();
        // 获取任务结果，如果没有完成会一直阻塞等待
        System.out.println("准备打印结果...");
        String result = completableFuture.get();
        System.out.println("计算结果:" + result);
    }
}
