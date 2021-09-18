package com.itheima.interfaceUSB;

public class Computer {
    public void useUSB(usb u) {
        u.connect();
        u.disconnect();
    }

    public void open() {
        System.out.println("starting up");
    }

    public void close() {
        System.out.println("shutting down");
    }

}
