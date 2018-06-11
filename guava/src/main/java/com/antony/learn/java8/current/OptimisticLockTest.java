/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.OptimisticTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午6:17:44
 * @version 1.0
 */
public class OptimisticLockTest {
    
    private static int count = 0;

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午6:17:44
     * @version 1.0
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();
        

        executor.submit(() -> {
            //乐观锁不阻塞其他线程获取锁
            long stamp = lock.tryOptimisticRead(); //如果已经有写锁拿到返回的标记等于0
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });
        
        //有时，将读锁转换为写锁而不用再次解锁和加锁十分实用。
        //StampedLock为这种目的提供了tryConvertToWriteLock()方法
        executor.submit(() -> {
            long stamp = lock.readLock();
            try {
                if (count == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);//不会阻塞
                    if (stamp == 0L) {//别的线程已经占用了写锁
                        System.out.println("Could not convert to write lock");
                        stamp = lock.writeLock();//阻塞当前线程，知道有可用的写锁
                    }
                    count = 23;
                }
                System.out.println(count);
            } finally {
                lock.unlock(stamp);
            }
        });

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
