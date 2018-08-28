/*
 * @projectName jyplatform
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.ImmutableMapTest
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * ImmutableMapTest
 *
 * @author wangqian
 * @version TODO
 * @description TODO
 * @date 2018/8/24 14:39
 */
public class ImmutableMapTest {
    public static void main(String[] args) {
        Map<String, String> aMap = Maps.newHashMap();
        Map params = ImmutableMap.of("name", "zhangsan", "age", "20");
        //params.forEach((k, v) -> System.out.println(k+":"+v));
        Map<String, String> left = Maps.newHashMap();
        left.put("1", "111");
        left.put("2", "222");
        left.put("left", "333Left");
        Map<String, String> right = Maps.newHashMap();
        right.put("1", "111");
        right.put("2", "222");
        right.put("right", "333Right");
        MapDifference<String, String> diff = Maps.difference(left, right);
        Map<String, String> onlyLeft = diff.entriesInCommon();
        onlyLeft.forEach((k, v) -> System.out.println(k+":"+v));
    }
}
