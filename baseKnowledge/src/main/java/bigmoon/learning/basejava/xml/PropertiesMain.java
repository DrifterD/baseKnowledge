/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: PropertiesMain.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-6-13 上午11:18      版本号        描述
 */
package bigmoon.learning.basejava.xml;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 读写properties文件操作
 *
 * @author bigmoon
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PropertiesMain {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @throws IOException 
     * @throws FileNotFoundException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) throws Exception {

        loadFile();
       
    }

    /**
     *  sotre时注意中文存储之后的文字
     * @author bigmoon
     * @params []
     * @return void
     * @see [相关类/方法]（可选）
     * @since 201022
     */
    public static void normalUsed()throws IOException{
        // create new properties and save it Properties.store
        Properties pros=new Properties();
        pros.setProperty("jdbc.name","bigmoon");
        pros.setProperty("chineseName","马文");
        pros.put("jdbc.url", "jdbc:\\mysql:xxxxx");
        pros.store(new FileOutputStream("test.properties"), "test for properties");
        System.out.println("save over,charset="+pros.getProperty("jdbc.url"));

        //load proprties edit it and save it with xml format
        Properties loadProperties=new Properties();
        loadProperties.load(new FileInputStream("test.properties"));
        PrintStream printWriter=System.out;
        loadProperties.list(printWriter);
//        System.out.println("jdbc.url="+loadProperties.getProperty("jdbc.url"));
        loadProperties.setProperty("jdbc.password", "sdfasecg");
        loadProperties.storeToXML(new FileOutputStream("proproties.xml"), "test proproties file save as xml file");
        System.out.println("save as xml over");
    }

    /**
     * properties加载文件，这里需要注意存在中文情况，
     * 由于properties-9001.properties文件是utf-8编码存储。但是加载在内存中时是通过iso8859-1编码，该编码不支持中文，若直接展示会出现乱码情况，
     * 所以需要先8859解码成对应的字节数组然后重新编码成utf8
     * @author bigmoon
     * @params []
     * @return void
     * @see [相关类/方法]（可选）
     * @since 201022
     */
    public static void loadFile()throws IOException{

        Properties properties=new Properties();
        properties.load(new FileInputStream("properties-9001.properties"));
        properties.list(System.out);
        System.out.println("中文字节码：chineseName="+new String(properties.getProperty("chineseName").getBytes("ISO-8859-1"), "utf8"));
    }

}
