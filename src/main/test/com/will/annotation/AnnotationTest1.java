package com.will.annotation;

import org.junit.Test;
import java.lang.reflect.Field;

public class AnnotationTest1 {
    @Test
    public void checkAge() throws IllegalAccessException {
        AnnotationTest ann = new AnnotationTest(1000);
        Field[] fileds = AnnotationTest.class.getFields();
        for(Field f: AnnotationTest.class.getFields()){
            CheckStr c = f.getAnnotation(CheckStr.class);
            if(c!=null){
                Object v = f.get(ann);
                if(v instanceof Integer){
                    Integer i = (Integer) v;
                    if(i<c.min()||i>c.max()){
                        throw new IllegalArgumentException("Inappropriate filed value "+i+" for field "+f);
                    }
                }
            }
        }
    }
}
