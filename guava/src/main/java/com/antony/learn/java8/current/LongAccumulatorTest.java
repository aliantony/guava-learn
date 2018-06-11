/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.LongAccumulatorTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月6日 上午9:41:33
 * @version 1.0
 */
public class LongAccumulatorTest {

    /**
     * @description 我们使用函数2 * x + y创建了LongAccumulator，初始值为1。
     * 每次调用accumulate(i)的时候，当前结果和值i都会作为参数传入lambda表达式。
     * LongAccumulator就像LongAdder那样，在内部维护一系列变量来减少线程之间的争用。
     * @param args
     * @author wangqian
     * @date 2018年6月6日 上午9:41:33
     * @version 1.0
     */
    public static void main(String[] args) {
        LongBinaryOperator op = (x, y) -> 2 * x + y;
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        ConcurrentUtils.stop(executor);

        System.out.println(accumulator.getThenReset()); // => 2539
    }

}
