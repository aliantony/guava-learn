/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.LockTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午6:00:52
 * @version 1.0
 */
public class LockTest {
    ReentrantLock lock = new ReentrantLock();
    int count = 0;
    
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            lock1.lock();
            try {
                    TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
            finally {
                lock1.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock1.isLocked());
            System.out.println("Held by me: " + lock1.isHeldByCurrentThread());
            boolean locked = lock1.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        stop(executor);
    }
    
    private static void  stop(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
            }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
