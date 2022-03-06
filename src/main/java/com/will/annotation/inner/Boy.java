package com.will.annotation.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boy {
    @Autowired
    Car car;

    public void drive(){
        car.run();
    }
}
