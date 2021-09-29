// 参考：https://www.jianshu.com/p/9bcac608c714
package com.will.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ProxyHandler implements InvocationHandler{
    private Object object;
    public ProxyHandler(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("hello before!");
        method.invoke(object,args);
        System.out.println("hello after");
        return null;
    }
}

public class SimpleAOP {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 动态代理
        System.out.println("===============动态代理1===============");
        HelloService helloService=new HelloServiceImpl();
        ProxyHandler handler=new ProxyHandler(helloService);
        HelloService service = (HelloService)Proxy.newProxyInstance(
                helloService.getClass().getClassLoader()
                ,helloService.getClass().getInterfaces()
                ,handler);
        service.sayHelloWorld();

        System.out.println("===============动态代理2===============");
        ByeService byeService = new ByeServiceImpl();
        ProxyHandler handler2=new ProxyHandler(byeService);
        ByeService bye = (ByeService)Proxy.newProxyInstance(
                ByeService.class.getClassLoader()
                ,byeService.getClass().getInterfaces()
                ,handler2);
        bye.sayBye();

    }
}
