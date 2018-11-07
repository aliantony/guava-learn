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
public class CompletableFutureTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> 100)
                .thenApplyAsync(i -> i * 10)
                .thenApply(i -> i.toString())
                .whenComplete((r, e) -> System.out.println(r + "_____" + e)); //1000_____null

        //若有异常
        CompletableFuture.supplyAsync(() -> 1 / 0)
                .thenApplyAsync(i -> i * 10)
                .thenApply(i -> i.toString())
                .whenComplete((r, e) -> System.out.println(r + "_____" + e)); //null_____java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero

        //上面效果 或者下面这么写也行（但上面那么写 连同异常都可以处理） 全部匿名方式 效率高 代码也优雅
        //CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> 100)
        //       .thenApplyAsync(i -> i * 10)
        //        .thenApply(i -> i.toString());
        //System.out.println(f.get()); //"1000"

        CompletableFuture<Void> f = CompletableFuture.supplyAsync(() -> 100)
                .thenAccept(x -> System.out.println(x)); //100
        //如果此句话get不调用  也是能够输出100的 上面也会有输出的
        System.out.println(f.join()); //null 返回null，所以thenAccept是木有返回值的

        //thenRun的案例演示
        CompletableFuture<Void> f2 = CompletableFuture.supplyAsync(() -> 100)
                .thenRun(() -> System.out.println("不需要入参")); //不需要入参
        System.out.println(f2.join()); //null 返回null，所以thenAccept是木有返回值的

        CompletableFuture<Void> f3 =  CompletableFuture.supplyAsync(() -> 100)
                // 第二个消费者：x,y显然是可以把前面几个的结果都拿到，然后再做处理
                .thenAcceptBoth(CompletableFuture.completedFuture(10), (x, y) -> System.out.println(x * y)); //1000
        System.out.println(f3.join()); //null

    }

}
