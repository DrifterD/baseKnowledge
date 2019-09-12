/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: ExtendsSuper.java
 * Author:   bigmoon
 * Date:     19-6-14 上午11:57
 * Description: baseKnowledge
 *
 */

package bigmoon.learning.basejava.generaic;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 测试泛型 extends 和super
 * extends  在集合中只能获取(get) 并且类型是 父级类型；不支持插入操作，集合没有确定具体类型，无法插入
 * super 子类是xxx的类型，在集合中只支持添加（set)且是XXX本身或者子类类型，不能get，因为不能确定具体集合类型
 *
 * 遵循PECS(producer extends, consumer super)规则
 * @author bigmoon
 * @see [相关类/方法]（可选）
 * @since 0628
 */
public class ExtendsSuper {

    public static void main(String[] args) {

        // extends 可以读取数据， 不可以添加数据
        List<? extends subInteger> numbers = new ArrayList<>();

        //正确 extends get是可以实现，获取类型为父级类型（subInteger)
        subInteger number = numbers.get(0);

        //错误 不能将父级类型自动转换成子级类型对象
//        subInterC integer=numbers.get(0);

        //错误 编译器无法确定List中对象类型，可能是new ArrayList<subInterC>,subInterB....
        // 由于无法确定具体类型不能添加实例
//        numbers.add(new subInterC(10));

        //super customer 不能获取，只能插入
        List<? super subInteger> superNumber = new ArrayList<supIntegerB>();
        //List 中类型不能确定，无法获取真正值
//        subInteger integer = superNumber.get(0);

        //正确 支持插入SubInteger 的本身或者子类，因为子类可以隐身转换成父类
        superNumber.add(new subInteger(2));
        superNumber.add(new subInterB(3));
        superNumber.add(new subInterC(4));

    }


    interface supIntegerA {

        int printlnA();

    }


    interface supIntegerB {

        int printlnB();

    }

    static class subInteger implements supIntegerA ,supIntegerB{

        int value;

        @Override
        public int printlnB() {
            return 0;
        }

        @Override
        public int printlnA() {
            return 0;
        }

        public subInteger(int value) {
            this.value = value;
        }

        Integer printSub() {
            System.out.println(this.value);
            return 0;
        }
    }

    static class subInterB extends subInteger{
        @Override
        public int printlnB() {
            return super.printlnB();
        }

        @Override
        public int printlnA() {
            return super.printlnA();
        }

        public subInterB(int value) {
            super(value);
        }

        @Override
        Integer printSub() {
            return super.printSub();
        }
    }

    static class subInterC extends  subInteger{
        @Override
        public int printlnB() {
            return super.printlnB();
        }

        @Override
        public int printlnA() {
            return super.printlnA();
        }

        public subInterC(int value) {
            super(value);
        }

        @Override
        Integer printSub() {
            return super.printSub();
        }
    }

}
