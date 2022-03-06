package com.will.spring.singleton;

public class Singleton {
    public static void main(String[] args) {
        Singleton4 singleton4 = Singleton4.Instance;
        singleton4.setName("Chao");
        System.out.println(singleton4.getName());
    }
}

// 饿汉
// 多线程安全，不过不能延迟初始化
class Singleton1 {
    private static final Singleton1 single = new Singleton1();

    private Singleton1() {
    }

    public Singleton1 getInstance() {
        return single;
    }
}


// 懒汉
// 多线程不安全
class Singleton2 {
    private static Singleton2 single;

    private Singleton2() {
    }

    public Singleton2 getInstance() {
        if (single == null) {
            single = new Singleton2();
        }
        return single;
    }
}

// 双重校验锁
class Singleton3{
    private volatile static Singleton3 single;

    private Singleton3(){}

    public Singleton3 getInstance(){
        if(single==null){
            synchronized(Singleton3.class){
                if(single==null){
                    single = new Singleton3();
                }
            }
        }
        return single;
    }
}

// 枚举
enum Singleton4{
    Instance;
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }
}

// 静态内部类
class Singleton51{
    private static Singleton51 singleton51;
    static {
        System.out.println("外部静态代码块："+System.currentTimeMillis());
    }

    public static final Singleton51 getInstance(){
        System.out.println("内部类调用："+System.currentTimeMillis());
        return Singleton52.single;
    }

    private static class Singleton52{

        private static final Singleton51 single = new Singleton51();
        static {
            System.out.println("实例化内部类："+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Singleton51 single = new Singleton51();
        System.out.println("开始调用内部类");
        Singleton51.getInstance();
    }
}

