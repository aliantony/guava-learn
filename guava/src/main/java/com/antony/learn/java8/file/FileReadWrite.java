/**
 * @projectName guava
 * @package com.antony.learn.java8.file
 * @className com.antony.learn.java8.file.FileReadWrite
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package com.antony.learn.java8.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * @description 要注意这些方法对内存并不十分高效，因为整个文件都会读进内存。文件越大，所用的堆区也就越大
 * @author wangqian
 * @date 2018年6月6日 下午3:31:54
 * @version 1.0
 */
public class FileReadWrite {

    /**
     * @description TODO
     * @param args
     * @author wangqian
     * @date 2018年6月6日 下午3:31:54
     * @version 1.0
     */
    public static void main(String[] args) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("res/nashorn1.js"));
            lines.add("print('foobar');");
            Files.write(Paths.get("res/nashorn1-modified.js"), lines);
        } catch (IOException e) {
        }

        /**
         * lines方法更高效，不会把整个文件装入内存，而是用函数式数据流来对其流式处理
         */
        try (Stream<String> stream = Files.lines(Paths.get("res/nashorn1-modified.js"))) {
            stream.filter(line -> line.contains("print")).map(String::trim).forEach(System.out::println);
        } catch (IOException e) {
        }

        Path path = Paths.get("res/nashorn1.js");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
        }

        Path path1 = Paths.get("res/output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path1)) {
            writer.write("print('Hello World');");
        } catch (IOException e) {
        }

        /**
         * BufferedReader也可以访问函数式数据流。lines方法在它所有行上面构建数据流
         */
        Path path2 = Paths.get("res/nashorn1.js");
        try (BufferedReader reader = Files.newBufferedReader(path2)) {
            long countPrints = reader.lines().filter(line -> line.contains("print")).count();
            System.out.println(countPrints);
        } catch (IOException e) {
        }
    }

}
