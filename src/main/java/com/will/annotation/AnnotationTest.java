package com.will.annotation;

public class AnnotationTest {
    @CheckStr(min=1,max=100)
    public int age;
    
    public AnnotationTest(int age){
        this.age=age;
    }
}
