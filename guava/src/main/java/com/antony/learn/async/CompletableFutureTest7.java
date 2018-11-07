/*
 * @projectName jyplatform
 * @package com.antony.learn.async
 * @className com.antony.learn.async.CompletableFuture
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

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
public class CompletableFutureTest7 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });
        CompletableFuture<List<Integer>> resultList = sequence(Arrays.asList(future1, future2));
        System.out.println(resultList.join()); //[100, 200]

    }


    /**
     * 可以把多个futures序列化起来  最终返回一个装载有结果的CompletableFuture即可  调用join方法就够了
     * 当然只能是同一类型哦（返回的结果）
     *
     * @param <T>     the type parameter
     * @param futures the futures
     * @return the completable future
     */
    public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
        //通过allOf方法把所有的futures放到一起  返回Void
        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        //遍历把每一个futures通过join方法把结果拿到  最终给返回出去 并且是用CompletableFuture包装着的
        return allDoneFuture.thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.<T>toList()));
    }

    //Java Future转CompletableFuture
    public static <T> CompletableFuture<T> toCompletable(Future<T> future, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }, executor);
    }

}
