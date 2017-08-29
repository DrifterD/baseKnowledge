/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: JDOMMain.java
 * Author:   17081794
 * Date:     2017年8月28日 下午5:17:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.yhx.basejava.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 * 〈一句话功能简述〉<br> 
 * jdom 操作xml
 * xml 加载 JAXBuilder --->jaxbuilder.builder ---->document
 * xml 保存：XMLOutputter
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class JDOMMain {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @throws IOException 
     * @throws JDOMException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) throws JDOMException, IOException {
        JDOMMain dom=new JDOMMain();
        dom.createXML();
        //dom.readXML();

    }
    
    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @throws JDOMException
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void createXML() throws JDOMException, IOException{
        
        Document doc=new Document();
        Element root =new Element("values");
        root.setAttribute("level","root");
        Element sub1=new Element("value");
        sub1.setAttribute("level","child").setAttribute("name","carNo").addContent("test content");
        Element sub2=new Element("value");
        sub2.setAttribute("level","child").setAttribute("name","charNo2");
        sub2.addContent(new CDATA("苏A935G3"));
        root.addContent(sub1).addContent(sub2);
        doc.addContent(root);
        XMLOutputter out=new XMLOutputter();
        
        out.output(doc, new FileOutputStream(new File("jdom.xml")));
    }
    
    private void readXML() throws JDOMException, IOException{
        SAXBuilder builder=new SAXBuilder();
     
        Document doc =builder.build(new File(Class.class.getResource("/").getPath()+"xml/jdom.xml"));
        Element root= doc.getRootElement();
        System.out.println(root.getAttributeValue("level"));
    }
    
}
