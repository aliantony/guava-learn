/**
 * @projectName guava
 * @package com.antony.learn.java8.file
 * @className com.antony.learn.java8.file.FileOperatorTest
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @description TODO
 * @author wangqian
 * @date 2018年6月6日 下午3:22:18
 * @version 1.0
 */
public class FileOperatorTest {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月6日 下午3:22:18
     * @version 1.0
     */
    public static void main(String[] args) {
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream
                .map(String::valueOf)
                .filter(path -> !path.startsWith("."))
                .sorted()
                .collect(Collectors.joining("; "));
            System.out.println("List: " + joined);
        } catch (IOException e) {
        }
        
        //查找文件
        Path start = Paths.get(""); //起始目录
        int maxDepth = 5; //查找深度
        //(path, attr) 匹配谓词
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).endsWith(".class"))) {
            String joined = stream
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("; "));
            System.out.println("Found: " + joined);
        } catch (IOException e) {
        }
        
        //walk会遍历每个文件，而不需要谓词
        Path start1 = Paths.get("");
        int maxDepth1 = 15;
        try (Stream<Path> stream = Files.walk(start1, maxDepth1)) {
            String joined = stream
                .map(String::valueOf)
                .filter(path -> path.endsWith(".class"))
                .sorted()
                .collect(Collectors.joining("; "));
            System.out.println("walk(): " + joined);
        } catch (IOException e) {
        }
    }

}
