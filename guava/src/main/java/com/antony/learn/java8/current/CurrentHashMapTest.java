/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.CurrentHashMapTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月6日 上午10:10:30
 * @version 1.0
 */
public class CurrentHashMapTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月6日 上午10:10:30
     * @version 1.0
     */
    public static void main(String[] args) {
        //可以并行执行
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");
        
        map.forEach(1, (key, value) ->
        System.out.printf("key: %s; value: %s; thread: %s\n",
            key, value, Thread.currentThread().getName()));
        
        //阈值1代表始终强制并行执行
        //currenthashmap无序，如果映射的多个元素都满足指定搜索函数，结果是非确定的
        String result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });
        System.out.println("Result: " + result);
        
        String result1 = map.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });

        System.out.println("Result: " + result1);
        
        
        /**
         * 第一个函数将每个键值对转换为任意类型的单一值。第二个函数将所有这些转换后的值组合为单一结果，
         * 并忽略所有可能的null值
         */
        String result2 = map.reduce(1,
            (key, value) -> {
                System.out.println("Transform: " + Thread.currentThread().getName());
                return key + "=" + value;
            },
            (s1, s2) -> {
                System.out.println("Reduce: " + Thread.currentThread().getName());
                return s1 + ", " + s2;
            });

        System.out.println("Result: " + result2);
    }

}
