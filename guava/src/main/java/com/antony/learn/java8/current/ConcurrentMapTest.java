/**
 * @projectName guava
 * @package com.antony.learn.java8.current
 * @className com.antony.learn.java8.current.ConcurrentMapTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.current;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月6日 上午9:45:16
 * @version 1.0
 */
public class ConcurrentMapTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月6日 上午9:45:16
     * @version 1.0
     */
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");
        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
        //线程安全的操作，key不存在才放到map
        String value = map.putIfAbsent("c3", "p1");
        System.out.println(value);    // p0
        //传入的键值不存在返回默认值
        String value1 = map.getOrDefault("hi", "there");
        System.out.println(value1);    // there
        
        //BiFunction二元lambda，entry的key等于rs2,则返回d55
        map.replaceAll((key, value2) -> "r2".equals(key) ? "d55" : value2);
        System.out.println(map.get("r2"));    // d55
        
        //第一个参数是key
        map.compute("foo", (key, value3) -> value3 + value3);
        System.out.println(map.get("foo"));   // barbar
        
        //computeIfAbsent() 和 computeIfPresent() 键存在和不存在才调用
        
        //对key为foo的元素用新值替换
        map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("foo"));   // boo was foo
    }

}
