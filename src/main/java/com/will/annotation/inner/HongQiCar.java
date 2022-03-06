package com.will.annotation.inner;

import org.springframework.stereotype.Component;

//@Component　GeelyCar和HongQiCar只能用一个
public class HongQiCar implements Car{
    @Override
    public void run() {
        System.out.println("HongQi Car run!");
    }
}
