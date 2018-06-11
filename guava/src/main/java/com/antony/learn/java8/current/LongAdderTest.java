/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.LongAdderTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * 
 * @description 当多线程的更新比读取更频繁时，这个类通常比原子数值类性能更好
 * LongAdder缺点是较高的内存开销
 * LongAdder提供了add()和increment()方法，就像原子数值类一样，同样是线程安全的
 * @author wangqian
 * @date 2018年6月6日 上午9:35:10
 * @version 1.0
 */
public class LongAdderTest {

    private static LongAdder adder = new LongAdder();

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月6日 上午9:35:10
     * @version 1.0
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000).forEach(i -> executor.submit(adder::increment));

        ConcurrentUtils.stop(executor);
        //不理解
        System.out.println(adder.sumThenReset()); // => 1000
    }

}
