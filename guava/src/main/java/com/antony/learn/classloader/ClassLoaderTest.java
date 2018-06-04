/**
 * @projectName guava
 * @package com.antony.learn.classloader
 * @className com.antony.learn.classloader.Snippet
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.classloader;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月1日 上午11:08:06
 * @version 1.0
 */
public class ClassLoaderTest {
    /**
     * @description TODO
     * @author wangqian
     * @date 2018年6月1日 上午11:08:06
     * @version 1.0
     */
    public static void main(String[] args) {
       //获取classpath的类加载器，app classloader
       System.out.println(ClassLoader.getSystemClassLoader());
    }
}

