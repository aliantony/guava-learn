package com.antony.learn.java8.stream;

import java.util.Optional;
import java.util.function.Supplier;

class Outer {
    Nested nested;
    public static void main(String[] args) {
        Outer outer = new Outer();
        //判断条件太多
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }
        //可以使用Optional的flatMap操作来完成相同的行为
        //避免空指针检查的方法一
        Optional.of(new Outer())
        .flatMap(o -> Optional.ofNullable(o.nested))
        .flatMap(n -> Optional.ofNullable(n.inner))
        .flatMap(i -> Optional.ofNullable(i.foo))
        .ifPresent(System.out::println);
        
        //避免空指针检查的方法二
        Outer obj = new Outer();
        resolve(() -> obj.getInner().getFoo()).ifPresent(System.out::println);
        
    }
        

    public Inner getInner() {
        return new Inner();
    }
    
    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}

class Nested {
    Inner inner;
}

class Inner {
    String foo = "我不为空，终于找到你";
    
    public String getFoo() {
        return foo;
    }
}

