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
public class CompletableFutureTest4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "abc");
        CompletableFuture<String> f = future.thenCombine(future2, (x, y) -> y + "-" + x);
        System.out.println(f.join()); //abc-100
        //它们的功能更类似thenAcceptBoth，只不过thenAcceptBoth是纯消费，它的函数参数没有返回值，
        // 而thenCombine的函数参数fn有返回值
        //thenAcceptBoth和runAfterBoth是当两个CompletableFuture都计算完成
        // acceptEither任意一个CompletableFuture执行完成
    }

}
