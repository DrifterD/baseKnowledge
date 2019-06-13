/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: B.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.base.defaultFunction;

public interface B extends A {

    default void hello(){
        System.out.println("print b from B");
    }

    static void staticMethod(){
        System.out.println("static print from B");

    }
}
