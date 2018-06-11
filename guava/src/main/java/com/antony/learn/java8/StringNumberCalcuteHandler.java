/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.StringNumberCalcuteHandler
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午6:31:18
 * @version 1.0
 */
public class StringNumberCalcuteHandler {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午6:31:18
     * @version 1.0
     */
    public static void main(String[] args) {
       String str = String.join(":", "foobar", "foo", "bar");
       System.out.println(str);
       
       String str2 = "foobar:foo:bar"
       .chars()
       .distinct()
       .mapToObj(c -> String.valueOf((char)c))
       .sorted()
       .collect(Collectors.joining());
       
       System.out.println(str2);
       
       String str3 = Pattern.compile(":")
       .splitAsStream("foobar:foo:bar")
       .filter(s -> s.contains("bar"))
       .sorted()
       .collect(Collectors.joining(":"));
       // => bar:foobar
       
       System.out.println(str3);
       
       Pattern pattern = Pattern.compile(".*@gmail\\.com");
       Stream.of("bob@gmail.com", "alice@hotmail.com")
           .filter(pattern.asPredicate())
           .count();
       // => 1
    }

}
