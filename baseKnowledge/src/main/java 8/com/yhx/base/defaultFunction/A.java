package com.yhx.base.defaultFunction;

public interface A {

    default void hello(){
        System.out.println("print a from A");
    }
}
