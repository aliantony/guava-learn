/*
 * @projectName jyplatform
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.StringPrefixSuffixTest
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * StringPrefixSuffixTest
 *
 * @author wangqian
 * @version TODO
 * @description TODO
 * @date 2018/8/24 14:56
 */
public class StringPrefixSuffixTest {
    public static void main(String[] args) {
            String input = "";
            boolean isNullOrEmpty = Strings.isNullOrEmpty(input);
            System.out.println("input " + (isNullOrEmpty?"is":"is not") + " null or empty.");
        //Strings.commonPrefix(a,b) demo
        String a = "com.jd.coo.Hello";
        String b = "com.jd.coo.Hi";
        String ourCommonPrefix = Strings.commonPrefix(a,b);
        System.out.println("a,b common prefix is " + ourCommonPrefix);

        //Strings.commonSuffix(a,b) demo
        String c = "com.google.Hello";
        String d = "com.jd.Hello";
        String ourSuffix = Strings.commonSuffix(c,d);
        System.out.println("c,d common suffix is " + ourSuffix);
        int minLength = 4;
        String padEndResult = Strings.padEnd("123", minLength, '0');
        System.out.println("padEndResult is " + padEndResult);
        String padStartResult = Strings.padStart("1", 2, '0');
        System.out.println("padStartResult is " + padStartResult);


        Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}")
                .trimResults()
                .omitEmptyStrings()
                .split("hello,word,,世界，水平");

        for (String item : splitResults) {
            System.out.println(item);
        }

        String toSplitString = "a=b;c=d,e=f";
        Map<String,String> kvs = Splitter.onPattern("[,;]{1,}").withKeyValueSeparator("=").split(toSplitString);
        for (Map.Entry<String,String> entry : kvs.entrySet()) {
            System.out.println(String.format("%s=%s", entry.getKey(),entry.getValue()));
        }

        String joinResult = Joiner.on(" ").join(new String[]{"hello","world"});
        System.out.println(joinResult);

        Map<String,String> map = new HashMap<String,String>();
        map.put("a", "b");
        map.put("c", "d");
        String mapJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(mapJoinResult);
    }
}
