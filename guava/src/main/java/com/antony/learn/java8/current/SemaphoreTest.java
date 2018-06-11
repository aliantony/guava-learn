/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.SemaphoreTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 
 * @description 信号量需要限制你程序某个部分的并发访问总数时非常实用
 * @author wangqian
 * @date 2018年6月5日 下午6:26:13
 * @version 1.0
 */
public class SemaphoreTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午6:26:13
     * @version 1.0
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Semaphore semaphore = new Semaphore(5);

        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    TimeUnit.SECONDS.sleep(5);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10)
            .forEach(i -> executor.submit(longRunningTask));

        stop(executor);
    }
    
    private static void stop(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

}
