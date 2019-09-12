/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: ClassC.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.base.defaultFunction;

/**
 *  接口静态方作为父类，且子类的父类集合中有且相同方法签名的静态方法时，需要声明式引用
 * @author
 * @return
 * @since 20190905
 */
public class ClassC implements A, B {

    public static void main(String[] args) {
        ClassC c = new ClassC();
        c.hello();
        //父级同时拥有相同今天方法，则无法识别。需要声明式引用
        B.staticMethod();
    }
}
