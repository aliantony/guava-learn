/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.MapTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description 正如前面已经提到的那样，map是不支持流操作的。而更新后的map现在则支持多种实用的新方法， 来完成常规的任务
 * @author wangqian
 * @date 2018年6月5日 下午2:12:55
 * @version 1.0
 */
public class MapTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午2:12:55
     * @version 1.0
     */
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            // 避免把空值放进去
            map.putIfAbsent(i, "val" + i);
        }

        // 接收一个消费者对象
        // map.forEach((id, val) -> System.out.println(val));

        // 使用函数来计算map的编码
        map.computeIfPresent(3, (num, val) -> val + num);
        // 对key为3的重新计算了
        String s = map.get(3); // val33
        System.out.println(s);

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9); // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23); // true
        System.out.println(map.get(23));

        map.computeIfAbsent(3, num -> "bam");
        map.get(3); // val33

        map.remove(3, "val3"); // key value都匹配才移除
        map.get(3); // val33

        map.remove(3, "val33");
        map.get(3); // null

        // 没有给个默认值
        map.getOrDefault(42, "not found"); // not found

        // 合并
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9); // val9

        // 没有key=9 val等于concat的entry,用key=9的val连接上newValue
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9); // val9concat
    }

}
