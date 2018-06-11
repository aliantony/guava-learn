/**
 * @projectName guava
 * @package com.antony.learn.java8.stream
 * @className com.antony.learn.java8.stream.StreamTest2
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.stream;

import java.util.stream.Stream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午3:37:51
 * @version 1.0
 */
public class StreamTest2 {
    public static void main(String[] args) {
        Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("a");
        }).map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        }).forEach(s -> System.out.println("forEach: " + s));
    }
}
