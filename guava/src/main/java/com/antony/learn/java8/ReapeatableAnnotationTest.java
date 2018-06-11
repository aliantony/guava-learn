/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.ReapeatableAnnotationTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午2:56:17
 * @version 1.0
 */
public class ReapeatableAnnotationTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午2:56:17
     * @version 1.0
     */
    public static void main(String[] args) {
        Hint hint = Person2.class.getAnnotation(Hint.class);
        System.out.println(hint); // null

        Hints hints1 = Person1.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length); // 2

        Hint[] hints2 = Person2.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length); // 2
    }

}
