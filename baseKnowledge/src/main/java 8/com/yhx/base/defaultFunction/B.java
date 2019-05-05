package com.yhx.base.defaultFunction;

public interface B extends A {

    default void hello(){
        System.out.println("print b from B");
    }
}
