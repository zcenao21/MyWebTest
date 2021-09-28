package com.will.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

interface SomeMethods{
    void boring();
    void boring1();
    void boring2();
    void interesting(String arg);
}

public class MethodSelector implements InvocationHandler {
    private Object proxid;

    public MethodSelector(Implementation implementation) {
        this.proxid=implementation;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        if(method.getName().equals("ineresting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxid,args);
    }

    public static void main(String[] args) {
        SomeMethods proxy=(SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxy.boring();
        proxy.interesting("ok");
    }
}

class Implementation implements SomeMethods{

    @Override
    public void boring() {
        System.out.println("this is boring method of Implementation.class");
    }

    @Override
    public void boring1() {
        System.out.println("this is boring1 method of Implementation.class");
    }

    @Override
    public void boring2() {
        System.out.println("this is boring2 method of Implementation.class");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("this is interesting method of Implementation.class");
    }
}



