/**
 * @projectName guava
 * @package com.antony.learn.java8.stream
 * @className com.antony.learn.java8.stream.ReduceTester
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午4:39:10
 * @version 1.0
 */
public class ReduceTester {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
            new Person("David", 12));
        //第一种将流中的元素归约为流中的一个元素
        persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2).ifPresent(System.out::println); // Pamela
        //第二个reduce方法接受一个初始值，和一个BinaryOperator累加器。这个方法可以用于从流中的其它Person对象中构造带有聚合后名称和年龄的新Person对象
        Person result = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
            p1.age += p2.age;
            p1.name += p2.name;
            return p1;
        });
        System.out.format("name=%s; age=%s", result.name, result.age);
        // name=MaxPeterPamelaDavid; age=76
        
        //第三个reduce对象接受三个参数：初始值，BiFunction累加器和BinaryOperator类型的组合器函数
        Integer ageSum = persons
            .stream()
            .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
        System.out.println();
        System.out.println(ageSum);  // 76
        
        //第三种的原理细节,组合器是在并行流的时候最后合并数据
        Integer ageSum1 = persons
            .stream()
            .reduce(0,
                (sum, p) -> {
                    System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                    return sum += p.age;
                },
                (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                    return sum1 + sum2;
                });

        // accumulator: sum=0; person=Max
        // accumulator: sum=18; person=Peter
        // accumulator: sum=41; person=Pamela
        // accumulator: sum=64; person=David
        
        Integer ageSum2 = persons
            .parallelStream()
            .reduce(0,
                (sum, p) -> {
                    System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                    return sum += p.age;
                },
                (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                    return sum1 + sum2;
                });

        // accumulator: sum=0; person=Pamela
        // accumulator: sum=0; person=David
        // accumulator: sum=0; person=Max
        // accumulator: sum=0; person=Peter
        // combiner: sum1=18; sum2=23
        // combiner: sum1=23; sum2=12
        // combiner: sum1=41; sum2=35
        
        System.out.println("ageSum2 = " + ageSum2);
    }
}
