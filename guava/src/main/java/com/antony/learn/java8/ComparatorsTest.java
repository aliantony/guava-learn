/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.ComparatorsTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.Comparator;

/**
 * 
 * @description Comparator接口在早期的Java版本中非常著名。Java 8 为这个接口添加了不同的默认方法。
 * @author wangqian
 * @date 2018年6月5日 下午1:51:06
 * @version 1.0
 */
public class ComparatorsTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午1:51:06
     * @version 1.0
     */
    public static void main(String[] args) {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1, p2));             // > 0
        System.out.println(comparator.reversed().compare(p1, p2));  // < 0
    }

}
