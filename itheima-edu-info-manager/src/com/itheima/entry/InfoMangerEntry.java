package com.itheima.entry;

import com.itheima.controller.OtherStudentController;
import com.itheima.controller.TeacherController;

import java.util.Scanner;

//import com.itheima.controller.StudentController;

public class InfoMangerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // main menu building
            System.out.println("-----Welcome to Heima Information Manager");
            System.out.println("1. Student Manager 2. Teacher Manager 3. Exit");
            String choice = sc.next();
            // switch to different function.
            switch (choice) {
                case "1":
                    OtherStudentController sContr = new OtherStudentController();
                    sContr.start();
                    break;
                case "2":
                    TeacherController tContr = new TeacherController();
                    tContr.start();
                    break;
                case "3":
                    System.out.println("Thanks for using Info System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error occurred");
            }
        }
    }
}
