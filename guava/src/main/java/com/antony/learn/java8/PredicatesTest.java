/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.PredicatesTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午1:35:03
 * @version 1.0
 */
public class PredicatesTest {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo"); // true
        predicate.negate().test("foo"); // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        boolean nn = nonNull.test(null);
        System.out.println(nn);
        System.out.println(isNull.test(null));

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test(""));
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println(isNotEmpty.test(""));
    }
}
