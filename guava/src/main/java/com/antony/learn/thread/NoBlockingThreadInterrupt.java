/**
 * @projectName guava
 * @package com.antony.learn.thread
 * @className com.antony.learn.thread.NoBlockingThreadInterrupt
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.thread;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月1日 下午10:43:26
 * @version 1.0
 */
public class NoBlockingThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    //判断当前线程是否被中断,非阻塞的线程中断需要自己判断中断状态
                    if (this.isInterrupted()){
                        System.out.println("线程中断");
                        break;
                    }
                }

                System.out.println("已跳出循环,线程中断!");
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();

        /**
         * 输出结果:
            线程中断
            已跳出循环,线程中断!
         */
    }
}
