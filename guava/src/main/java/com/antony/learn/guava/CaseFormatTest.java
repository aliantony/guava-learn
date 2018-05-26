/**
 * @projectName guava
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.CaseFormatTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.guava;

import com.google.common.base.CaseFormat;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月26日 下午8:54:03
 * @version 1.0
 */
public class CaseFormatTest {
    public static void main(String args[]) {
        CaseFormatTest tester = new CaseFormatTest();
        tester.testCaseFormat();
    }

    private void testCaseFormat() {
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }
}
