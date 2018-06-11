package com.antony.learn.java8;
class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
    
    public static void main(String[] args) {
        Something some = new Something();
        Converter<String, String> convert = some::startsWith;
        String converted = convert.convert("Java");
        System.out.println(converted);    // "J"
    }
}