package com.antony.learn.guava;
public final class Plate<T> {
    T item;
    public Plate(T t) {
    item = t;
    }
    public void set(T t) {
    item = t;
    }
    public T get() {
    return item;
    }
}