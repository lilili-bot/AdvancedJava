package com.itheima.interfaceUSB;

public class test {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.open();
        c.useUSB(new Mouse());
        c.close();
    }
}
