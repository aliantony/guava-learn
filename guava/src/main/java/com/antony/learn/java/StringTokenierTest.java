/**
 * @projectName guava
 * @package com.antony.learn.java
 * @className com.antony.learn.java.StringTokenierTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java;

import java.io.File;
import java.util.StringTokenizer;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月1日 上午11:03:57
 * @version 1.0
 */
public class StringTokenierTest {
    // ExtClassLoader类中获取路径的代码
    private static File[] getExtDirs() {
        // 加载<JAVA_HOME>/lib/ext目录中的类库
        String s = System.getProperty("java.ext.dirs");
        File[] dirs;
        if (s != null) {
            StringTokenizer st = new StringTokenizer(s, File.pathSeparator);
            int count = st.countTokens();
            dirs = new File[count];
            for (int i = 0; i < count; i++) {
                dirs[i] = new File(st.nextToken());
            }
        } else {
            dirs = new File[0];
        }
        return dirs;
    }
    
    public static void main(String[] args) {
        File[] files = getExtDirs();
        
    }
}
