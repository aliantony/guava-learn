/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.SortList
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 上午11:41:48
 * @version 1.0
 */
public class SortList {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 上午11:41:50
     * @version 1.0
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a,b) -> b.compareTo(a));
    }

}
