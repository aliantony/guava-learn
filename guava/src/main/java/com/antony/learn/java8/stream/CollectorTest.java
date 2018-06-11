/**
 * @projectName guava
 * @package com.antony.learn.java8.stream
 * @className com.antony.learn.java8.stream.CollectorTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午3:52:09
 * @version 1.0
 */
public class CollectorTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午3:52:09
     * @version 1.0
     */
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
            new Person("David", 12));
        List<Person> filtered =
            persons
                .stream()
                .filter(p -> p.name.startsWith("P"))
                .collect(Collectors.toList());

        System.out.println(filtered);    // [Peter, Pamela]
        
        Map<Integer, List<Person>> personsByAge = persons
            .stream()
            .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
            .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
        
        Double averageAge = persons
            .stream()
            .collect(Collectors.averagingInt(p -> p.age));

        System.out.println(averageAge);     // 19.0
        
        IntSummaryStatistics ageSummary =
            persons
                .stream()
                .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
        // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
        
        String phrase = persons
            .stream()
            .filter(p -> p.age >= 18)
            .map(p -> p.name)
            .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);
        // In Germany Max and Peter and Pamela are of legal age.
        
        Collector<Person, StringJoiner, String> personNameCollector =
            Collector.of(
                () -> new StringJoiner(" | "),          // supplier
                (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                (j1, j2) -> j1.merge(j2),               // combiner
                StringJoiner::toString);                // finisher

        String names = persons
            .stream()
            .collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID
    }

}
