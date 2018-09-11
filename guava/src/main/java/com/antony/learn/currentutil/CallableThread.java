package com.antony.learn.currentutil;

import java.util.concurrent.*;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("进入CallableThread的call()方法, 开始睡觉, 睡觉时间为" + System.currentTimeMillis());
        Thread.sleep(5000);
        return "123";
    }

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        CallableThread ct = new CallableThread();
        Future<String> f = es.submit(ct);
        es.shutdown();

        Thread.sleep(5000);
        System.out.println("主线程等待5秒, 当前时间为" + System.currentTimeMillis());

        String str = f.get();
        System.out.println("Future已拿到数据, str = " + str + ", 当前时间为" + System.currentTimeMillis());

    }
}
