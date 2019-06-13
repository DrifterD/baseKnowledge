/*
 * Copyright (C), 2002-2017, yhx,All Rights Reserved.
 * FileName: DOMMain.java
 * Author:   yhx
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * yhx     19-5-23 下午6:17      版本号        描述
 */
package yhx.learning.basejava.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * 〈一句话功能简述〉<br> 
 * 通过dom方式加载xml并处理。主要流程：
 * DocumentBuilderFactory --->install Builder 
 *  --->builder.parse(...) --------> 读取xml document文件
 *
 *通过Dom方式存储xml
 * TranformFactory ---> new Transform ----->transform.transform(newDoc)
 *
 *
 *
 * @author yhx
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DOMMain {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= factory.newDocumentBuilder();     
        Document doc=builder.parse(Class.class.getResourceAsStream("/xml/test.xml"));
        try {
            createNewDocXML(builder);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            System.out.println("xml doc faild for new doc");
            e.printStackTrace();
        }
       if(builder.isValidating()){
           System.out.println("validate xml");
       }else{
           System.out.println("no validate xml");
       }
        Element ele= doc.getDocumentElement();
        
        for(int i=0;i<ele.getChildNodes().getLength();i++){
            System.out.println("nodeName="+ele.getChildNodes().item(i).getNodeName()+", content="+ele.getChildNodes().item(i));
        }
    }
    
    private static void createNewDocXML(DocumentBuilder builder) throws TransformerException{
        
        if(builder!=null){
            
            Document newDoc=builder.newDocument();
            Element root=newDoc.createElement("values");
            Element subEle= newDoc.createElement("value");
            subEle.setAttribute("name", "2");            
            subEle.appendChild(newDoc.createTextNode("测试内容"));
            root.appendChild(subEle);
            newDoc.appendChild(root);
            TransformerFactory facotry=TransformerFactory .newInstance();
            Transformer transformer= facotry.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(newDoc), new StreamResult(new File("testNewXML.xml")));
            
            
        }
    }

}
