/**
 * @projectName guava
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.StringSplitterTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.guava;

import java.util.Iterator;

import com.google.common.base.Splitter;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月26日 下午5:36:33
 * @version 1.0
 */
public class StringSplitterTest {
    public static void main(String args[]) {
        StringSplitterTest tester = new StringSplitterTest();
        tester.testSplitter();
    }

    private void testSplitter() {
        Iterable<String> result = Splitter.on(',').trimResults()
        .omitEmptyStrings().split("foo,bar,,   qux,");
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            String str = (String)iter.next();
            System.out.println(str);
        }
    }
}
