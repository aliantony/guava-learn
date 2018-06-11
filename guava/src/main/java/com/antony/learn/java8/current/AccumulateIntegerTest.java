/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.AccumulateIntegerTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月6日 上午9:31:45
 * @version 1.0
 */
public class AccumulateIntegerTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月6日 上午9:31:45
     * @version 1.0
     */
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
            .forEach(i -> {
                Runnable task = () ->
                //二元操作，做累加
                atomicInt.accumulateAndGet(i, (n, m) -> n + m);
                executor.submit(task);
            });

        ConcurrentUtils.stop(executor);

        System.out.println(atomicInt.get());    // => 499500
    }

}
