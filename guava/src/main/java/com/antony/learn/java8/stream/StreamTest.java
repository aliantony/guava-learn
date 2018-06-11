/**
 * @projectName guava
 * @package com.antony.learn.java8.stream
 * @className com.antony.learn.java8.stream.StreamTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午3:24:00
 * @version 1.0
 */
public class StreamTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午3:24:00
     * @version 1.0
     */
    public static void main(String[] args) {
        List<String> myList =
            Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);

        // C1
        // C2
        
        Arrays.asList("a1", "a2", "a3")
        .stream()
        .findFirst()
        .ifPresent(System.out::println);  // a1
        
        Stream.of("a1", "a2", "a3")
        .findFirst()
        .ifPresent(System.out::println);  // a1
        
        IntStream.range(1, 4)
        .forEach(System.out::println);
        
        Arrays.stream(new int[] {1, 2, 3})
        .map(n -> 2 * n + 1)
        .average()
        .ifPresent(System.out::println);  // 5.0
        
        Stream.of("a1", "a2", "a3")
        .map(s -> s.substring(1))
        .mapToInt(Integer::parseInt)
        .max()
        .ifPresent(System.out::println);  // 3
        
        IntStream.range(1, 4)
        .mapToObj(i -> "a" + i)
        .forEach(System.out::println);
        
        Stream.of(1.0, 2.0, 3.0)
        .mapToInt(Double::intValue)
        .mapToObj(i -> "a" + i)
        .forEach(System.out::println);
        
        
        Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
            System.out.println("filter: " + s); //流程操作只会在终止操作后才执行
            return true;
        });
        
        Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
            System.out.println("filter: " + s);
            return true;
        })
        .forEach(s -> System.out.println("forEach: " + s));
        
        
        Stream.of("d2", "a2", "b1", "b3", "c")
        .map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        })
        .anyMatch(s -> {
            System.out.println("anyMatch: " + s);
            return s.startsWith("A");
        });

        // map:      d2
        // anyMatch: D2
        // map:      a2
        // anyMatch: A2
        
        Stream.of("d2", "a2", "b1", "b3", "c")
        .map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        })
        .filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("A");
        })
        .forEach(s -> System.out.println("forEach: " + s)); //上一步返回true才执行
    }

}
