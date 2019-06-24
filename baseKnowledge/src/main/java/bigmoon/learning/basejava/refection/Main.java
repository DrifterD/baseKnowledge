/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Main.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-6-13 上午11:18      版本号        描述
 */

package bigmoon.learning.basejava.refection;

import java.net.URL;
import java.net.URLClassLoader;

//通过classLoader 加载class文件，不管是任何方式,class 那么必须是类全名（包名+类名）
public class Main {

    public static void main(String[] args)throws Exception{

//        Class beanClass=Thread.currentThread().getContextClassLoader().loadClass("com.bigmoon.basejava.refection.TestBean");
        test();
        return ;
//        File file=new File("F:\\IDEA_WORKSPACE\\baseKnowledge\\baseKnowledge\\baseKnowledge\\target\\classes\\com\\bigmoon\\basejava\\refection\\TestBean.class");
//        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//        byte[] cache=new byte[521];
//        byte[] classByte=new byte[1];
//        int readCount;
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        while((readCount=inputStream.read(cache))!=-1){
//            byteArrayOutputStream.write(cache,0,readCount);
//        }
//        Class beanClass=Thread.currentThread().getContextClassLoader()
//        Object obj2=beanClass.newInstance();
//        beanClass.newInstance();
//        System.out.println("over");
    }

    private static void test() throws Exception{
        URLClassLoader loader = new URLClassLoader(new URL[]{Main.class.getResource("F:\\IDEA_WORKSPACE\\baseKnowledge\\baseKnowledge\\baseKnowledge\\target\\classes\\com\\bigmoon\\basejava\\refection\\")});
        Class class2=loader.loadClass("bigmoon.learning.basejava.refection.TestBean");
        class2.newInstance();
    }
}
