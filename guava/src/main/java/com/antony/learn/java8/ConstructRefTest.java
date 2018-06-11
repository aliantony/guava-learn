/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.ConstructRefTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午12:35:15
 * @version 1.0
 */
public class ConstructRefTest {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}
