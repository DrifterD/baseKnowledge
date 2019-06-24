/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: XML2Object.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */
package bigmoon.learning.basejava.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.dom4j.DocumentException;

/**
 * 〈一句话功能简述〉<br> 
 * xml文件转换成java 对象
 * 
 * 1.首先对象和xml形成映射关系。通过注解完成映射。主要有xmlRootElement,xmlelement,xmlattribute.....只能再getter或者setter上
 * 2. JAXContext ----->jaxcontext.createMarshaller|jaxcontext.createUnMarshaller -----> marshaller.marshal()
 *   
 *
 * @author bigmoon
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class XML2Object {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @throws DocumentException 
     * @throws JAXBException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) throws DocumentException, JAXBException {
        
        XML2Object xmlClient=new XML2Object();
        xmlClient.object2XML();
    }
    
    private static void object2XML() throws JAXBException{
        
        Values vs=new Values();
        vs.setLevel("root.root");
        
        for(int i=0;i<4;i++){
            Value v=new Value("son"+i,"value"+i,"内容"+i);
            vs.add(v);
        }
        
        JAXBContext context=JAXBContext.newInstance(Values.class);
        Marshaller shaller= context.createMarshaller();
        shaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        shaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        shaller.marshal(vs, System.out);  
        System.out.flush();
    }
    
    /**
     * 功能描述: <br>
     * 通过xml文件转换成java对象
     *
     * @throws JAXBException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static void xml2Object() throws JAXBException{
        
        JAXBContext content=JAXBContext.newInstance(Values.class);
        Unmarshaller unmarshaller=content.createUnmarshaller();
        unmarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        Values bean=(Values)unmarshaller.unmarshal(new File("jdom.xml"));       
        System.out.println("root.level="+bean.getLevel());
        
        for(Value v:bean.getValue()){
            System.out.println(v.getLevel()+","+v.getContent()+","+v.getName());
        }    
    }
    
    @XmlRootElement(name="values")
    public static class Values{

        private String level;
        
       
        private List<Value> value;

        /**
         * @return the level
         */
        public String getLevel() {
            return level;
        }

        /**
         * @param level the level to set
         */
        @XmlAttribute(name="level")
        public void setLevel(String level) {
            this.level = level;
        }

        /**
         * @return the value
         */
        public List<Value> getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        @XmlElement(name="value")
        public void setValue(List<Value> value) {
            this.value = value;
        }
        
        public Values(){}  
        
        public void add(Value v){
            
            if(null==this.getValue()){
                this.value=new ArrayList<Value>();
            }
            
            this.value.add(v);            
        }
        
    }
    
    
//    @XmlRootElement(name="value")
    public static class Value{
        
        
        private String level;
        
       
        private String name;
        
       
        private String content;
        
        /**
         * @return the content
         */
        public String getContent() {
            return content;
        }
        /**
         * @param content the content to set
         */
        @XmlValue
        public void setContent(String content) {
            this.content = content;
        }
        /**
         * @return the level
         */
        public String getLevel() {
            return level;
        }
        /**
         * @param level the level to set
         */
        @XmlAttribute(name="level")
        public void setLevel(String level) {
            this.level = level;
        }
        /**
         * @return the name
         */
        public String getName() {
            return name;
        }
        /**
         * @param name the name to set
         */
        @XmlAttribute(name="name")
        public void setName(String name) {
            this.name = name;
        }
        
        public Value(){}
        
        public Value(String level,String name,String content){
            this.level=level;
            this.name=name;
            this.content=content;
        }
    }
}
