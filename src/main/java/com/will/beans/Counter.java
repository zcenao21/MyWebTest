package com.will.beans;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Counter {
    private int count;

    public boolean addOne(){
        this.count++;
        return true;
    }
}
