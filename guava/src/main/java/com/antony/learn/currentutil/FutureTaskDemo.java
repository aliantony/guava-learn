/*
 * @projectName jyplatform
 * @package com.antony.learn.currentutil
 * @className com.antony.learn.currentutil.FutureTaskDemo
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.currentutil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTaskDemo
 *
 * @author wangqian
 * @version TODO
 * @description TODO
 * @date 2018/8/28 17:06
 */
public class FutureTaskDemo implements Callable<String> {
    @Override
    public String call() throws Exception
    {
        System.out.println("进入CallableThread的call()方法, 开始睡觉, 睡觉时间为" + System.currentTimeMillis());
        Thread.sleep(10000);
        return "123";
    }
    public static void main(String[] args) throws Exception
    {
        ExecutorService es = Executors.newCachedThreadPool();
        CallableThread ct = new CallableThread();
        FutureTask<String> f = new FutureTask<String>(ct);
        es.submit(f);
        es.shutdown();

        Thread.sleep(5000);
        System.out.println("主线程等待5秒, 当前时间为" + System.currentTimeMillis());

        String str = f.get();
        System.out.println("Future已拿到数据, str = " + str + ", 当前时间为" + System.currentTimeMillis());
    }
}
