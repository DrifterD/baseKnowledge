/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: ClassC3.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.base.defaultFunction;

/**
 * 当一个类实现两个独立的接口且默认方法是一样的时候会编译报错：
 * inherits unrelated default methodName.....
 */
public class ClassC3 implements B1,A {

    @Override
    public void hello() {
        //java 8 中新语法：I.super.methodName I:设置为公司
        A.super.hello();
    }

    public static void main(String[] args){

        new ClassC3().hello();
    }
}
