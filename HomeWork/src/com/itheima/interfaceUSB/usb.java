package com.itheima.interfaceUSB;

/*
1.定义USB接口:（开启功能）（关闭功能）

2.定义笔记本类:（开机功能）（关机功能）

3.定义鼠标类:要符合USB接口

4.定义测试类:创建电脑对象,依次调用开机方法,使用USB设备, 关机方法
 */
public interface usb {

    void connect();

    void disconnect();

}
