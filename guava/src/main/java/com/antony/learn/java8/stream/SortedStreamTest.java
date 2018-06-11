/**
 * @projectName guava
 * @package com.antony.learn.java8.stream
 * @className com.antony.learn.java8.stream.SortedStreamTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午3:38:45
 * @version 1.0
 */
public class SortedStreamTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午3:38:45
     * @version 1.0
     */
    public static void main(String[] args) {
       /* Stream.of("d2", "a2", "b1", "b3", "c").sorted((s1, s2) -> {
            System.out.printf("sort: %s; %s\n", s1, s2);
            return s1.compareTo(s2);
        }).filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("a");
        }).map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        }).forEach(s -> System.out.println("forEach: " + s));*/
        
        //重排调用链来优化操作
        Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("a");
        })
        .sorted((s1, s2) -> { //永远不会调用，因为filter把输入集合减少成1个元素
            System.out.printf("sort: %s; %s\n", s1, s2);
            return s1.compareTo(s2);
        })
        .map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        })
        .forEach(s -> System.out.println("forEach: " + s));
        
        Stream<String> stream =
            Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok 终止操作关闭了流
        //Java8的数据流不能被复用。一旦你调用了任何终止操作，数据流就关闭了
        //stream.noneMatch(s -> true);   // exception
        
        //想要执行的终止操作创建新的数据流调用链
        Supplier<Stream<String>> streamSupplier =
            () -> Stream.of("d2", "a2", "b1", "b3", "c")
                    .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok

    }

}
