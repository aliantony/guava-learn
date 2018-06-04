package com.antony.learn.thread;

public class AccountingSyncBad implements Runnable {
    static int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // new新实例
        Thread t1 = new Thread(new AccountingSyncBad());
        // new新实例
        Thread t2 = new Thread(new AccountingSyncBad());
        t1.start();
        t2.start();
        // join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        // 此处有线程安全问题，因为两个线程用的是不同的实例对象作为锁,可以在
        // increase方法为静态方法，就是类变量作为锁就安全了
        t1.join();
        t2.join();
        System.out.println(i);
    }
}