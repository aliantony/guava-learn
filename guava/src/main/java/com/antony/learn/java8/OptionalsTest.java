/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.OptionalsTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.Optional;

/**
 * 
 * @description Optional不是一个函数式接口，而是一个精巧的工具接口，用来防止NullPointerException产生
 * @author wangqian
 * @date 2018年6月5日 下午1:53:29
 * @version 1.0
 */
public class OptionalsTest {

    /**
     * @description Optional是一个简单的值容器，这个值可以是null， 也可以是non-null。
     * 考虑到一个方法可能会返回一个non-null的值， 也可能返回一个空值。为了不直接返回null，我们在Java
     *              8中就返回一个Optional.
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午1:53:29
     * @version 1.0
     */
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent()); // true
        System.out.println(optional.get()); // "bam"
        System.out.println(optional.orElse("fallback")); // "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
    }

}
