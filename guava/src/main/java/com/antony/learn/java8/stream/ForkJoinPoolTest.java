/**
 * @projectName guava
 * @package com.antony.learn.java8.stream
 * @className com.antony.learn.java8.stream.ForkJoinPoolTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.stream;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * 
 * @description 并行流使用公共的ForkJoinPool，由ForkJoinPool.commonPool()方法提供
 * -Djava.util.concurrent.ForkJoinPool.common.parallelism=5设置该jvm参数增减公共池的大小
 * 所有并行流操作都共享相同的JVM相关的公共ForkJoinPool。
 * 所以你可能需要避免实现又慢又卡的流式操作，因为它可能会拖慢你应用中严重依赖并行流的其它部分。
 * @author wangqian
 * @date 2018年6月5日 下午4:50:20
 * @version 1.0
 */
public class ForkJoinPoolTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午4:50:20
     * @version 1.0
     */
    public static void main(String[] args) {
        //底层线程池的大小最大为五个线程 -- 取决于CPU的物理核数
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism()); // 3
        
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
        .parallelStream()
        .filter(s -> {
            System.out.format("filter: %s [%s]\n",
                s, Thread.currentThread().getName());
            return true;
        })
        .map(s -> {
            System.out.format("map: %s [%s]\n",
                s, Thread.currentThread().getName());
            return s.toUpperCase();
        })
        .forEach(s -> System.out.format("forEach: %s [%s]\n",
            s, Thread.currentThread().getName()));
        
        
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
        .parallelStream()
        .filter(s -> {
            System.out.format("filter: %s [%s]\n",
                s, Thread.currentThread().getName());
            return true;
        })
        .map(s -> {
            System.out.format("map: %s [%s]\n",
                s, Thread.currentThread().getName());
            return s.toUpperCase();
        })
        .sorted((s1, s2) -> {
            System.out.format("sort: %s <> %s [%s]\n",
                s1, s2, Thread.currentThread().getName());
            return s1.compareTo(s2);
        })
        .forEach(s -> System.out.format("forEach: %s [%s]\n",
            s, Thread.currentThread().getName()));
        
    }

}
