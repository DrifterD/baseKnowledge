package com.yhx.base.defaultFunction;

/**
 * 当一个类实现两个独立的接口且默认方法是一样的时候会编译报错：
 * inherits unrelated default methodName.....
 */
public class ClassC3 implements B1,A {

    @Override
    public void hello() {
        A.super.hello();
    }

    public static void main(String[] args){

        new ClassC3().hello();
    }
}
