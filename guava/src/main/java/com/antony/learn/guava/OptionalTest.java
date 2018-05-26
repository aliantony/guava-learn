/**
 * @projectName guava
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.OptionalTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.guava;

import com.google.common.base.Optional;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月26日 下午5:25:35
 * @version 1.0
 */
public class OptionalTest {
    public static void main(String args[]) {
        OptionalTest guavaTester = new OptionalTest();

        Integer value1 = null;
        Integer value2 = new Integer(10);
        // Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        // Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(guavaTester.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        // Optional.or - returns the value if present otherwise returns
        // the default value passed.
        Integer value1 = a.or(new Integer(0));

        // Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }
}
