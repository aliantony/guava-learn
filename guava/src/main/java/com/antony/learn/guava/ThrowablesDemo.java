/*
 * @projectName jyplatform
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.ThrowablesDemo
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.guava;

import com.google.common.base.Throwables;

import java.sql.SQLException;

/**
 * ThrowablesDemo
 *
 * @author wangqian
 * @version TODO
 * @description TODO
 * @date 2018/8/28 13:08
 * 我们可以通过Throwables.getRooCause(Throwable)获得根异常
 * 可以使用getCausalChain方法获得异常的列表
 * 可以通过getStackTraceAsString获得异常堆栈的字符串
 */
public class ThrowablesDemo {
    public static void main(String[] args) {

    }
    public void doSomething() throws Throwable {
        //ignore method body
    }

    public void doSomethingElse() throws Exception {
        //ignore method body
    }

    public void doIt() throws SQLException {
        try {
            doSomething();
        } catch (Throwable throwable) {
            Throwables.propagateIfInstanceOf(throwable, SQLException.class);//如果异常的类型是SQLException，那么抛出这个异常
            Throwables.propagateIfPossible(throwable);//如果异常是Error类型，那么抛出这个类型，否则将抛出RuntimeException，我们知道RuntimeException是不需要在throws中声明的
        }
    }
}
