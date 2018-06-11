/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.ParallelStreamsTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午2:09:14
 * @version 1.0
 */
public class ParallelStreamsTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午2:09:14
     * @version 1.0
     */
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
        //并行排序
        long t3 = System.nanoTime();

        long count1 = values.parallelStream().sorted().count();
        System.out.println(count1);

        long t4 = System.nanoTime();

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t4 - t3);
        System.out.println(String.format("parallel sort took: %d ms", millis1));

    }

}
