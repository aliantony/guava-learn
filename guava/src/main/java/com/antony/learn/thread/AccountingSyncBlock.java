/**
 * @projectName guava
 * @package com.antony.learn.thread
 * @className com.antony.learn.thread.AccountingSyncBlock
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.thread;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月1日 下午10:20:14
 * @version 1.0
 */
public class AccountingSyncBlock implements Runnable {
    static AccountingSyncBlock instance = new AccountingSyncBlock();
    static int i = 0;

    @Override
    public void run() {
        // 省略其他耗时操作....
        // 使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized (instance) {
            for (int j = 0; j < 1000000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
