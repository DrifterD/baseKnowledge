/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: Dom4JMain.java
 * Author:   17081794
 * Date:     2017年8月28日 下午2:05:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.yhx.basejava.xml;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Dom4JMain {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @throws IOException
     * @throws DocumentException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) throws IOException, DocumentException {
        Dom4JMain domClient = new Dom4JMain();
       // domClient.createDocXml("");
        //domClient.readDocXML("test4DOM4j.xml");
        domClient.convertingStr2XML("test4DOM4j.xml");
    }

    /**
     * 功能描述: 创建xml文档<br>
     * 〈功能详细描述〉
     *
     * @param path
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void createDocXml(String path) throws IOException {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("values");
        root.addElement("value").addAttribute("t", "1").addText("element1").addCDATA("cada<>").addAttribute("t2", "bc");
        root.addElement("value").addAttribute("t", "2").addText("element 2").addAttribute("t2", "a");

        // Method 1
        FileWriter out = null;
        try {
            out = new FileWriter("test4DOM4j.xml");
            doc.write(out);
            out.flush();
        } finally {

            if (out != null) {
                out.close();
            }
        }

        // // method 2 lets write to a file
        // XMLWriter writer =null;
        // try {
        // writer = new XMLWriter(new FileWriter("output.xml"));
        // writer.write(doc);
        // writer.close();
        // }finally{
        //
        // }
    }
    


    /**
     * 功能描述: 通过SAX读取xml文件<br>
     * 这里也测试使用xpath功能，但是必须依赖jaxen.jar 
     *
     * @param path
     * @throws DocumentException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void readDocXML(String path) throws DocumentException{
        
        SAXReader reader=new SAXReader();
        Document doc=reader.read(new File("test4DOM4j.xml"));
        Element root =doc.getRootElement();
        Iterator<Element> it=root.elementIterator();
        
        while(it.hasNext()){
            Element tmp=it.next();
            System.out.println(String.format("nodeName=%s,attr=%s,text=%s", tmp.getName(),tmp.attribute("t").getValue(),tmp.getText()));
        }
        System.out.println("xpath.......................");
        List nodes=root.selectNodes("//value/@t2");
        
        for(Iterator<Node> it2=nodes.iterator();it2.hasNext();){
            Node tmpNode=it2.next();
            System.out.println(String.format("name=%s,attr=%s,text=%s",tmpNode.getName(),tmpNode.valueOf("@t"),tmpNode.getText()));  
        }
                
    }
    
    /**
     * 功能描述: <br>
     * 把xml 字符串转换成xml对象。
     *
     * @param path
     * @throws IOException 
     * @throws DocumentException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void convertingStr2XML(String path) throws IOException, DocumentException{
        
        InputStream in=new BufferedInputStream(new FileInputStream(path));
        byte[] cache=new byte[512];
        ByteArrayOutputStream  cahce2=new ByteArrayOutputStream();
        
        int length=-1;
        StringBuilder sb=new StringBuilder();
        
        while((length=in.read(cache))!=-1){
            //System.out.write(cache, 0,length);
            cahce2.write(cache, 0, length);
            sb.append(new String(cache));
        }
        
        System.out.println(cahce2.toString());
        System.out.println(cahce2.size());
        System.out.println("without trim size="+sb.toString().length()+", trim size="+sb.toString().trim().length());
        
        in.close();
        
        //convert string to xml
        Document doc=DocumentHelper.parseText(sb.toString().trim());
        
        List list=doc.selectNodes("//value");
        
        for(Iterator<Node> it=list.iterator();it.hasNext();){
            Node tmpNode=it.next();
            System.out.println(String.format("name=%s,attr=%s,text=%s",tmpNode.getName(),tmpNode.valueOf("@t"),tmpNode.getText()));         
        }
        
        
        
    }
    
    
}
