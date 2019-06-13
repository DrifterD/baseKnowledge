/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: ClassC.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */

package yhx.learning.base.defaultFunction;

public class ClassC implements A, B {
    public static void main(String[] args) {
        ClassC c = new ClassC();
        c.hello();
        B.staticMethod();
    }
}
