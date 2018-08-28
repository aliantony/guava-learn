/*
 * @projectName jyplatform
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.ImmutableDemo
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * ImmutableDemo
 *
 * @author wangqian
 * @version TODO
 * @description TODO
 * @date 2018/8/28 13:17
 */
public class ImmutableDemo {
    public static void main(String[] args) {
        Set<String> immutableNamedColors = ImmutableSet.<String>builder()
                .add("red", "green","black","white","grey")
                .build();
        //immutableNamedColors.add("abc");
        ImmutableSet.of("red","green","black","white","grey");
        ImmutableSet.copyOf(new String[]{"red","green","black","white","grey"});
        for (String color : immutableNamedColors) {
            System.out.println(color);
        }
        BiMap<String,String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一","Monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");

        System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
    }
}
