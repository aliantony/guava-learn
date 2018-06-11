/**
 * @projectName guava
 * @package com.antony.learn.java8
 * @className com.antony.learn.java8.SummaryTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月5日 下午1:26:28
 * @version 1.0
 */
public class SummaryTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月5日 下午1:26:28
     * @version 1.0
     */
    public static void main(String[] args) {
        int num = 1; //会被当做final来处理，不能重新赋值
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        stringConverter.convert(2);     // 3
        //num =3 ; error
        //接口的默认方法不能在lambda表达式内访问
        //Formula formula = (a) -> sqrt( a * 100);
    }

}
