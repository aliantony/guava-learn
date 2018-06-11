/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.ScheduleThreadTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午5:46:38
 * @version 1.0
 */
public class ScheduleThreadTest {
    public static void main(String[] args) {
       /* ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        //除了具有future的全部方法外，还能获取剩余延时
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);
        
        ScheduledExecutorService executor1 =     Executors.newScheduledThreadPool(1);

        Runnable task1 = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;
        int period = 1;
        executor1.scheduleAtFixedRate(task1, initialDelay, period, TimeUnit.SECONDS);*/
        
        
        ScheduledExecutorService executor2 =         Executors.newScheduledThreadPool(1);

        Runnable task2 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };
         
        //会等待一个任务执行完了，第二个任务开始前的间隔，上一个方法不会
        executor2.scheduleWithFixedDelay(task2, 0, 1, TimeUnit.SECONDS);
    }
}
