package com.will.annotation.inner;


import org.springframework.stereotype.Component;

@Component
public class GeelyCar implements Car{
    @Override
    public void run() {
        System.out.println("Geely Car run!");
    }
}
