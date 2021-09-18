package com.itheima.interfaceUSB;

public class Mouse implements usb {
    public void connect() {
        System.out.println("connecting");
    }

    public void disconnect() {
        System.out.println("disconnecting");
    }
}
