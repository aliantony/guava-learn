/**
 * @projectName guava
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.StringJoinerTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.Files;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月26日 下午5:31:57
 * @version 1.0
 */
public class StringJoinerTest {
    public static void main(String args[]) throws  Exception{
        StringJoinerTest tester = new StringJoinerTest();
        tester.testJoiner();
        Map<String, String> userIdNameMap = new HashMap<>();
        userIdNameMap.put("123", "张三");
        userIdNameMap.put("124", "张刘");
        userIdNameMap.put("125", "张起");
        String s = Joiner.on(";").withKeyValueSeparator("|").join(userIdNameMap);
        System.out.println(s);
        Iterable<String> bs = Splitter.on(",").trimResults().omitEmptyStrings().split(" a,,b , c ,");
        bs.forEach(k -> System.out.println(k));
        String from  = "this is test guava's Files tool class王谦";
        Files.append(from, new File("D:/wangqian.txt"), Charset.forName("UTF-8"));
    }

     private void testJoiner(){
        System.out.println(Joiner.on(",")
           .skipNulls()
           .join(Arrays.asList(1,2,3,4,5,null)));
     }
}
