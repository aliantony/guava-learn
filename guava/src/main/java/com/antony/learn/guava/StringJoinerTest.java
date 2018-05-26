/**
 * @projectName guava
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.StringJoinerTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.guava;

import java.util.Arrays;

import com.google.common.base.Joiner;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月26日 下午5:31:57
 * @version 1.0
 */
public class StringJoinerTest {
    public static void main(String args[]){
        StringJoinerTest tester = new StringJoinerTest();
        tester.testJoiner();  
     }

     private void testJoiner(){
        System.out.println(Joiner.on(",")
           .skipNulls()
           .join(Arrays.asList(1,2,3,4,5,null,6)));
     }
}
