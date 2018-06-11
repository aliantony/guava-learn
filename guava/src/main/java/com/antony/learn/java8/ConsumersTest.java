/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.ConsumersTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.function.Consumer;

/**
 * 
 * @description Consumer代表了在一个输入参数上需要进行的操作
 * @author wangqian
 * @date 2018年6月5日 下午1:50:05
 * @version 1.0
 */
public class ConsumersTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午1:50:05
     * @version 1.0
     */
    public static void main(String[] args) {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }

}
