/**
 * @projectName guava
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.GenericExtendAndSuper
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.guava;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年5月30日 下午3:45:50
 * @version 1.0
 */
public class GenericExtendAndSuper {
    public static void main(String[] args) {
         //可以把Fruit及Fruit子类的List赋给appList2,但不能往里存Fruit和
         //它的子类，因为它不能确定具体是什么类型,往往用在方法的返回类型声明中
         //? extends xxx 只能用于方法返回类型限定
         List <? extends Fruit> appList2 = new ArrayList<Apple>();
         //appList2.add(new Fruit());
         //appList2.add(new Apple());
         //appList2.add(new RedApple());
        
        //? 既不能用于方法参数传入，也不能用于方法返回。
        /**
         *  super 可用于参数类型限定，不能用于返回类型限定
         * （换句话说：? supper xxx 只能用于方法传参，
         *  因为jdk能够确定传入为xxx的*子类*，返回只能用Object类接收）。
         */
        List<? super Fruit> appList = new ArrayList();
        appList.add(new Fruit());
        appList.add(new Apple());
        appList.add(new RedApple());
        
        List<Object> list = new ArrayList<Object>();  
        list.add(new Integer(5));  
        Object a = list.get(0);  
    }
}
