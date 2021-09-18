package com.itheima.javahw.Domain;

/*
1、

##[题目一]
分析事物的共性，并抽取出正确的继承体系
现有基础班老师（BaseTeacher）和就业班老师（WorkTeacher）两个类，两者都含有姓名和年龄两个属性，还有一个讲课的行为teach，但不同的是，基础班老师的teach方法输出【基础班老师讲JavaSE】，就业班老师的teach方法输出【就业班老师讲JavaEE】，请用代码实现。
运行结果：
张三老师...23
基础班老师讲JavaSE
李四老师...24
就业班老师讲JavaEE


##【训练目标】：
能够独立分析事物抽取出正确的继承体系


##【思路分析】：
1.    两个类都有属性的姓名年龄，行为的teach方法均为共性内容，是否可以抽取？
2.    BaseTeacher和WorkTeacher作为子类，对于teach方法都有自己的实现方式，这时候需要做什么？
3.    测试类创建两个类的对象，获取属性打印，并调用teach方法
 */

public class Teacher {
    private String name;
    private String age;

    public Teacher(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Teacher() {
    }

    ;

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getAge() {
        return age;
    }

    public String setAge(String age) {
        this.age = age;
        return age;
    }

    public void teach() {
        System.out.println("基础班老师讲JavaSE");
    }
}
