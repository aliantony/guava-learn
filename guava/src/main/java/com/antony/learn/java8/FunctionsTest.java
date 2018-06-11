/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.FunctionsTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.function.Function;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午1:38:28
 * @version 1.0
 */
public class FunctionsTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午1:38:28
     * @version 1.0
     */
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        //先执行toInteger再执行参数
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123"); // "123"
        //先执行参数再执行调用者
        toInteger.compose(String::valueOf);
    }

}
