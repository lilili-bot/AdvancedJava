package com.itheima.controller;

import com.itheima.domain.Student;

import java.util.Scanner;

public class OtherStudentController extends BaseStudentController {

    // Scanner receive the data from user.
    private Scanner sc = new Scanner(System.in);

    @Override
    public Student inputStudentInfo(String stuId) {
        System.out.println("Please enter Student name.");
        String stuName = sc.next();
        System.out.println("Please enter Student age.");
        String stuAge = sc.next();
        System.out.println("Please enter Student birthday.");
        String stuBirthday = sc.next();
        // 使用有参构造方法来完成student类的实例化。
        Student stu = new Student(stuId, stuName, stuAge, stuBirthday);
        return stu;
    }
}
