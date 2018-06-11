/**
 * @projectName guava
 * @package com.antony.learn.java8.stream
 * @className com.antony.learn.java8.stream.FlatMapTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午4:27:09
 * @version 1.0
 */
public class FlatMapTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午4:27:09
     * @version 1.0
     */
    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
        
        //flatMap处理一个entry需要映射多个返回对象的情况
        foos.stream()
        .flatMap(f -> f.bars.stream())
        .forEach(b -> System.out.println(b.name));
        
        //简化后的写法
        IntStream.range(1, 4)
        .mapToObj(i -> new Foo("Foo" + i))
        .peek(f -> IntStream.range(1, 4)
            .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
            .forEach(f.bars::add))
        .flatMap(f -> f.bars.stream())
        .forEach(b -> System.out.println(b.name));
        
        

    }

}
