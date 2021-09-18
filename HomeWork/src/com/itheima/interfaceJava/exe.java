package com.itheima.interfaceJava;

public interface exe {
    public static final int num = 10;

    public abstract void method();

    public default void show() {
        System.out.println("i am the default method in the interface");
    }

    public static void staticMethod() {
        System.out.println("i am the static method in the interface.");
    }
}
