package com.itheima.controller;

import java.util.Scanner;

public class TeacherController {

    private Scanner sc = new Scanner(System.in);

    public void start() {
        TeacherLoop:
        while (true) {
            // main menu building
            System.out.println("-----Welcome to Heima Student Manager-------");
            System.out.println("1.Add  2.Delete  3.Update 4. Check 5. Exit");
            // Scanner receive the data from user.
            String choice = sc.next();
            // switch to different function.
            switch (choice) {
                case "1":
                    addTeacher();
                    break;
                case "2":
                    //delStudentById();
                    break;
                case "3":
                    //updateStudent();
                    break;
                case "4":
                    //findAllStudent();
                    break;
                case "5":
                    System.out.println("Thanks for using Student Manager.");
                    break TeacherLoop;
                default:
                    System.out.println("Error occurred");
            }
        }
    }

    private void addTeacher() {
        System.out.println("test iu");
    }
}
