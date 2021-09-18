package com.itheima.constructor;

public class test {
    public static void main(String[] args) {
        Student stu1 = new Student();
        Student stu2 = new Student(23, "tom", "34", "11-11", "01");
        System.out.println(stu1 + "\n" + stu2);
    }
}
