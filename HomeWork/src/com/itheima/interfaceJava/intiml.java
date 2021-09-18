package com.itheima.interfaceJava;


public class intiml implements exe {
    // interface 中默认的是抽象方法，抽象方法必须被实现类重写。
    // interface 中可以定义：抽象方法，静态方法和default方法。
    @Override
    public void method() {
        System.out.println("i am the override method from implement class");
    }

    // default method is not mandatory to be override.
    @Override
    public void show() {
        System.out.println("i am override default show method. done by the implement class");
    }

}
