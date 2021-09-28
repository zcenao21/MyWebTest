package com.will.spring.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleIoc {
    private Map<String,Object> objMap;

    public SimpleIoc(String xmlPath) throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        objMap = new HashMap<>();
        getBeans(xmlPath);
    }

    public Object getObj(String objClass){
        return objMap.get(objClass);
    }

    public void getBeans(String xmlPath) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(xmlPath));
        List<Node> beans = document.selectNodes("/beans/bean");
        for(Node bean: beans){
            Element classNode = (Element) bean;
            String classStr = classNode.attributeValue("class");
            String classId = classNode.attributeValue("id");
            Object obj = Class.forName(classStr).newInstance();
            List<Node> properties=bean.selectNodes("property");
            for(Node property:properties){
                Element element = (Element) property;
                String attName = element.attributeValue("name");
                String attVal = element.attributeValue("value");
                String ref = element.attributeValue("ref");

                if(attName!=null&&attName.length()>0&&attVal!=null&&attVal.length()>0){
                    try{
                        Field filed = obj.getClass().getDeclaredField(attName);
                        filed.setAccessible(true);
                        filed.set(obj,attVal);
                    }catch (NoSuchFieldException e){
                        System.out.println("No such attribute:"+attName);
                    }
                }else if(attName!=null&&attName.length()>0&&ref!=null&&ref.length()>0){
                    try{
                        Field filed = obj.getClass().getDeclaredField(attName);
                        filed.setAccessible(true);
                        filed.set(obj,getObj(ref));
                    }catch (NoSuchFieldException e){
                        System.out.println("No such attribute:"+attName);
                    }
                }

            }
            objMap.put(classId,obj);
        }
    }
}
