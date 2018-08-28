/*
 * @projectName jyplatform
 * @package com.antony.learn.guava
 * @className com.antony.learn.guava.IteratorsDemo
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.guava;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * IteratorsDemo
 *
 * @author wangqian
 * @version TODO
 * @description TODO
 * @date 2018/8/28 13:25
 */
public class IteratorsDemo {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("Apple", "Pear", "Peach", "Banana");
        boolean allIsStartsWithP = Iterators.all(list.iterator(), s -> s.startsWith("P"));
        System.out.println("all result == " + allIsStartsWithP);
        Iterators.filter(list.iterator(), s -> s.startsWith("P"));
        String ret = Iterators.find(list.iterator(), input -> input.length() == 5);
        System.out.println(ret);
        Iterator<Integer> countIterator = Iterators.transform(list.iterator(), input -> input.length());
        countIterator.forEachRemaining(s -> System.out.println(s));
    }


}
