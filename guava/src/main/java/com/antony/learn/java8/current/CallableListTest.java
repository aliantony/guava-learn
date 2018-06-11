/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.CallableListTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午5:40:46
 * @version 1.0
 */
public class CallableListTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午5:40:46
     * @version 1.0
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");

        executor.invokeAll(callables).stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }).forEach(System.out::println);
        
        ExecutorService executor1 = Executors.newWorkStealingPool();

        List<Callable<String>> callables1 = Arrays.asList(
        callable("task1", 2),
        callable("task2", 1),
        callable("task3", 3));

        String result;
        try {
            result = executor.invokeAny(callables1);
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
       
    }
    
    static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

}
