package com.antony.learn.java8;
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    //在lambda表达式内部访问成员变量和静态变量是允许的
    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}