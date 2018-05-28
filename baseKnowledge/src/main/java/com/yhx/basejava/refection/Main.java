package com.yhx.basejava.refection;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

//通过classLoader 加载class文件，不管是任何方式,class 那么必须是类全名（包名+类名）
public class Main {

    public static void main(String[] args)throws Exception{

//        Class beanClass=Thread.currentThread().getContextClassLoader().loadClass("com.yhx.basejava.refection.TestBean");
        test();
        return ;
//        File file=new File("F:\\IDEA_WORKSPACE\\baseKnowledge\\baseKnowledge\\baseKnowledge\\target\\classes\\com\\yhx\\basejava\\refection\\TestBean.class");
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
        URLClassLoader loader = new URLClassLoader(new URL[]{Main.class.getResource("F:\\IDEA_WORKSPACE\\baseKnowledge\\baseKnowledge\\baseKnowledge\\target\\classes\\com\\yhx\\basejava\\refection\\")});
        Class class2=loader.loadClass("com.yhx.basejava.refection.TestBean");
        class2.newInstance();
    }
}
