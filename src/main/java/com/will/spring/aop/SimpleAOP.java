package com.will.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Advice implements InvocationHandler {
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("天才！");
        return method.invoke(o,objects);
    }
}

public class SimpleAOP {
    public void hello(){
        System.out.println("hello world!");
    }

    public static Object proxy(Object aop, Advice advice){
        return Proxy.newProxyInstance(aop.getClass().getClassLoader(),aop.getClass().getInterfaces(), advice);
    }

    public static void main(String[] args) {
        SimpleAOP aop = (SimpleAOP)proxy(new SimpleAOP(),new Advice());
        aop.hello();
    }
}
