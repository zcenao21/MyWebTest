package com.will.spring.aop;

interface HelloService {
    void sayHelloWorld();
}

class HelloServiceImpl implements HelloService {
    public void sayHelloWorld() {
        System.out.println("hello world!");
    }
}

interface ByeService {
    void sayBye();
}

class ByeServiceImpl implements ByeService {
    public void sayBye() {
        System.out.println("bye bye!");
    }
}

class HelloProxy implements HelloService{
    private HelloService helloInterface = new HelloServiceImpl();

    @Override
    public void sayHelloWorld() {
        System.out.println("hello before!");
        helloInterface.sayHelloWorld();
        System.out.println("hello after");
    }
}

class ByeProxy implements ByeService{
    private ByeService byeService = new ByeServiceImpl();

    @Override
    public void sayBye() {
        System.out.println("bye before!");
        byeService.sayBye();
        System.out.println("bye after");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        // 静态代理
        System.out.println("===============静态代理1===============");
        HelloProxy proxy=new HelloProxy();
        proxy.sayHelloWorld();

        System.out.println("===============静态代理2===============");
        ByeProxy proxy2=new ByeProxy();
        proxy2.sayBye();
    }
}
