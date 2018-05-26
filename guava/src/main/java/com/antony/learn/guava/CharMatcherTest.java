/**
 * @projectName guava
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.CharMatcherTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.guava;

import com.google.common.base.CharMatcher;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月26日 下午8:47:46
 * @version 1.0
 */
public class CharMatcherTest {
    public static void main(String args[]) {
        CharMatcherTest tester = new CharMatcherTest();
        tester.testCharMatcher();
    }

    private void testCharMatcher() {
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123")); // only the digits
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("     Mahesh     Parashar ", ' '));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh123", "*")); // star out all digits
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_UPPER_CASE).retainFrom("MAhesh123"));
        // eliminate all characters that aren't digits or lowercase
    }
}
