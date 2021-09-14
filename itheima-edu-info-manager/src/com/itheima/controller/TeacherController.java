package com.itheima.controller;

import com.itheima.domain.Teacher;
import com.itheima.service.TeacherService;

import java.util.Scanner;

public class TeacherController {

    private Scanner sc = new Scanner(System.in);
    private TeacherService tService = new TeacherService();


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
                    delTeacherById();
                    break;
                case "3":
                    updateStudentById();
                    break;
                case "4":
                    CheckTeachers();
                    break;
                case "5":
                    System.out.println("Thanks for using Student Manager.");
                    break TeacherLoop;
                default:
                    System.out.println("Error occurred");
            }
        }
    }

    // update teacher info.
    public void updateStudentById() {
        String updateId = inputTeacherId();
        Teacher newTeacher = inputTeacherInfo(updateId);
        tService.updateTeacherById(newTeacher, updateId);
        System.out.println("The information is updated.");
    }


    public void delTeacherById() {
        // get DelID
        String id = inputTeacherId();
        tService.delTeacherById(id);
        System.out.println("The information is deleted.");
    }

    // code optimization: inputTeacherId.
    public String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("Please enter id.");
            id = sc.next();
            boolean isExist = tService.isExists(id);
            if (!isExist) {
                System.out.println("The ID is not exist.");
            } else {
                break;
            }
        }
        return id;
    }

    // find all students.
    public void CheckTeachers() {
        // get result from Teachers list from service.
        Teacher[] allTeachers = tService.findAllTeachers();
        // If result is null, return the system is still empty.
        if (allTeachers == null) {
            System.out.println("The system is empty.");
            return;
        }else{
            // The result is not null, iterate the list and print out information.
            for (int i = 0; i < allTeachers.length; i++) {
                Teacher teacher = allTeachers[i];
                if (teacher != null) {
                    System.out.println(teacher.getId() + " " + teacher.getAge() + " " + teacher.getName() + " " + teacher.getBirthday());
                }
            }
        }

    }

    // addStudent method
    public void addTeacher() {
        // receive user input.
        String teacherID;
        while (true) {
            System.out.println("Please type teacher ID.");
            teacherID = sc.next();
            // check if the id is exit.
            boolean exists = tService.isExists(teacherID);
            if (exists) { // if exists, while carry one and request for another id.
                System.out.println("The id is already used, please enter another one.");
            } else { // if not exists, break while loop.
                break;
            }
        }
        // get teach information from method inputTeacherInfo.
        Teacher newTeacherInfo = inputTeacherInfo(teacherID);
        // pass the new teacher information to the teacher service to add and get true or false result.
        boolean addResult = tService.addStudent(newTeacherInfo);
        if (addResult) {
            System.out.println("The teacher information is added.");
        }
    }

    public Teacher inputTeacherInfo(String teacherID) {
        // Teacher id will be saved in the new teacher object.
        Teacher newTeacher = new Teacher();
        newTeacher.setId(teacherID);
        // receive name, age and birthday.
        System.out.println("Please type teacher name.");
        String teacherName = sc.next();
        System.out.println("Please type teacher age.");
        String teacherAge = sc.next();
        System.out.println("Please type teacher birthday.");
        String teacherBirthday = sc.next();
        // saving age, name, birthday in the teacher object.
        newTeacher.setName(teacherName);
        newTeacher.setAge(teacherAge);
        newTeacher.setBirthday(teacherBirthday);
        return newTeacher;
    }
}
