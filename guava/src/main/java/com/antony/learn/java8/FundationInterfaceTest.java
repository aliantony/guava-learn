/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.FundationInterfaceTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 上午11:49:08
 * @version 1.0
 */
public class FundationInterfaceTest {
    public static void main(String[] args) {
        
        /**
         * lamda表达式相当于函数接口的一个抽象方法的具体实现
         */
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted); // 123
        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("123");
        System.out.println(converted1);   // 123
    }
}
