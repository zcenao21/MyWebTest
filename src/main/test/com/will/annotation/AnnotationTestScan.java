package com.will.annotation;

import com.will.annotation.inner.Boy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTestScan {
    @Test
    public void testDI() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);
        Boy boy = (Boy)context.getBean("boy");
        boy.drive();
    }
}
