/*
 * @projectName jyplatform
 * @package com.antony.learn.async
 * @className com.antony.learn.async.CompletableFuture
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture
 *
 * @author wangqian
 * @version 1.0.0
 * 但是anyOf和applyToEither不同。anyOf接受任意多的CompletableFuture但是applyToEither只是判断两个CompletableFuture,anyOf返回值的计算结果是参数中其中一个CompletableFuture的计算结果，
 * applyToEither返回值的计算结果却是要经过fn处理的。当然还有静态方法的区别，线程池的选择等
 * @description TODO
 * @date 2018/11/7 14:30
 */
public class CompletableFutureTest6 {
    public static void main(String[] args) {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        //CompletableFuture<Void> f =  CompletableFuture.allOf(future1,future2);
        CompletableFuture<Object> f = CompletableFuture.anyOf(future1, future2);
        System.out.println(f.join());
    }


}
