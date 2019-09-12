/*
 * Copyright (c) 2004- 2019 All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * FileName: FinalizeEscapeGC.java
 * Author:   bigmoon
 * Date:     19-9-11 下午7:53
 * Description: baseKnowledge
 *
 */

package bigmoon.learning.basejava.gc;

/**
 * 〈一句话功能简述〉<br>
 * 测试 对象可以在垃圾回收时实现“自救”测试,为了更加深入学习jvm GC机制
 * 任何对象的finalize只会被系统(应该是指向jvm)自动调用一次！！！
 * @author bigmoon
 * @see [相关类/方法]（可选）
 * @since 0905
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am alive");
    }

    @Override
    protected void finalize() throws Throwable {

        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("第一次发生GC ，看对象是否能自救");
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        //finalize 方法执行低级，等待0.5秒
        Thread.sleep(500);

        if (SAVE_HOOK == null) {
            System.out.println("我挂了");
        } else {
            SAVE_HOOK.isAlive();
        }

        System.out.println("GC 发生第二次，看对象是否能自救");
        SAVE_HOOK = null;
        System.gc();
        //finalize 方法执行低级，等待0.5秒
        Thread.sleep(500);

        if (SAVE_HOOK == null) {
            System.out.println("我挂了");
        } else {
            SAVE_HOOK.isAlive();
        }
    }
}
