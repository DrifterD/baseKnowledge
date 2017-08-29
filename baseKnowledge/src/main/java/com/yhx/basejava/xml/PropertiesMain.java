/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: PropertiesMain.java
 * Author:   17081794
 * Date:     2017年8月29日 下午3:20:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.yhx.basejava.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 读写properties文件操作
 *
 * @author 17081794
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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // create new properties and save it Properties.store
        Properties pros=new Properties();
        pros.setProperty("jdbc.name","yhx");
        pros.put("jdbc.url", "jdbc:\\mysql:xxxxx");
        pros.store(new FileOutputStream("test.properties"), "test for properties");
        System.out.println("save over");
        
        //load proprties edit it and save it with xml format
        Properties loadProperties=new Properties();
        loadProperties.load(new FileInputStream("test.properties"));
        System.out.println("jdbc.url="+loadProperties.getProperty("jdbc.url"));
        loadProperties.setProperty("jdbc.password", "sdfasecg");
        loadProperties.storeToXML(new FileOutputStream("proproties.xml"), "test proproties file save as xml file");
        System.out.println("save as xml over");
       
    }

}
