package com.itheima.controller;

import com.itheima.domain.Student;

import java.util.Scanner;

public class StudentController extends BaseStudentController {
    // Scanner receive the data from user.
    private Scanner sc = new Scanner(System.in);

    public Student inputStudentInfo(String stuId) {
        System.out.println("Please enter Student name.");
        String stuName = sc.next();
        System.out.println("Please enter Student age.");
        String stuAge = sc.next();
        System.out.println("Please enter Student birthday.");
        String stuBirthday = sc.next();
        Student stu = new Student();
        stu.setId(stuId);
        stu.setName(stuName);
        stu.setAge(stuAge);
        stu.setBirthday(stuBirthday);

        return stu;
    }


}
