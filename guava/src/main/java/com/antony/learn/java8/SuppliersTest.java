/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.SuppliersTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.function.Supplier;

/**
 * 
 * @description Supplier接口产生一个给定类型的结果。与Function不同的是，Supplier没有输入参数。
 * @author wangqian
 * @date 2018年6月5日 下午1:46:11
 * @version 1.0
 */
public class SuppliersTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午1:46:11
     * @version 1.0
     */
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get(); // new Person
    }

}
