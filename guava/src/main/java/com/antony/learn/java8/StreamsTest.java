/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.StreamsTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @description java.util.Stream表示了某一种元素的序列，在这些元素上可以进行各种操作。 Stream操作可以是中间操作，也可以是完结操作
 * @author wangqian
 * @date 2018年6月5日 下午1:58:35
 * @version 1.0
 */
public class StreamsTest {

    /**
     * @description map不能作为Stream的源,list,set顺序或并行操作
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午1:58:35
     * @version 1.0
     */
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        stringCollection
        .stream()
        .filter((s) -> s.startsWith("a"))
        .forEach(System.out::println);
        
        stringCollection
        .stream()
        .sorted((a, b) -> a.compareTo(b) )
        .filter((s) -> s.startsWith("a"))
        .forEach(System.out::println);
        
        stringCollection
        .stream()
        .map(String::toUpperCase)
        .sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);
        
        
        boolean anyStartsWithA =
            stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
            stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
            stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
        
        long startsWithB =
            stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3
        
        Optional<String> reduced =
            stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }

}
