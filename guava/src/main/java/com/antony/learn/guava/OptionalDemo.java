package com.antony.learn.guava;

import com.google.common.base.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        /*Optional<Student> possibleNull = Optional.of(null);
        possibleNull.get();*/
        Optional<Student> possibleNull = Optional.absent();
        Student jim = possibleNull.get();

    }
    public static class Student { }


}