package com.itheima.controller;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService(); // only after create the object, then we can use the method under his object.
    // Scanner receive the data from user.
    private Scanner sc = new Scanner(System.in);

    // Start Student Information Management System.
    public void start() {
        StudentLoop:
        while (true) {
            // main menu building
            System.out.println("-----Welcome to Heima Student Manager");
            System.out.println("1.Add  2.Delete  3.Update 4. Check 5. Exit");
            // Scanner receive the data from user.
            String choice = sc.next();
            // switch to different function.
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    delStudentById();
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("Thanks for using Student Manager.");
                    break StudentLoop;
                default:
                    System.out.println("Error occurred");
            }
        }
    }

    public void updateStudent() {
        /*
        String updateId;
        while (true) {
            // get student id.
            System.out.println("Please enter student ID, which you want to update.");
            updateId = sc.next();
            // pass student id to student service, see if it exits.
            boolean exists = studentService.isExists(updateId);
            if (!exists) {
                // if not, return message to user, that the given ID is not exist.
                System.out.println("The student ID " + updateId + " is not exit.");
            } else {
                // otherwise, break the loop, move to delete process.
                break;
            }
        }
         */

        String updateId = inputStudentId();
        // if yes, create a student object to save update information.
        /*
        System.out.println("Please enter new name.");
        String updateName = sc.next();
        System.out.println("Please enter new age.");
        String updateAge = sc.next();
        System.out.println("Please enter new birthday.");
        String updateBirthday = sc.next();
        Student newStudent = new Student();
        newStudent.setId(updateId);
        newStudent.setName(updateName);
        newStudent.setBirthday(updateBirthday);
        newStudent.setAge(updateAge);
         */
        Student newStudent = inputStudentInfo(updateId);
        studentService.updateStudent(updateId, newStudent);
        System.out.println("The information is updated successfully.");
    }

    // Receive data from the user.
    public void addStudent() {
        // Create a Student Object to receive data from user.
        String stuID;
        while (true) {
            System.out.println("Please enter Student ID.");
            stuID = sc.next();
            boolean flag = studentService.isExists(stuID);
            if (flag) {
                System.out.println("The id is exist, please try another one.");
            } else {
                break;
            }
        }
        /*

        System.out.println("Please enter Student name.");
        String stuName = sc.next();
        System.out.println("Please enter Student age.");
        String stuAge = sc.next();
        System.out.println("Please enter Student birthday.");
        String stuBirthday = sc.next();

        Student stu = new Student();

        stu.setId(stuID);
        stu.setName(stuName);
        stu.setAge(stuAge);
        stu.setBirthday(stuBirthday);

         */
        // pass the student information to the StudentServer. Create a StudentServer Object to receive stu.

        Student stu = inputStudentInfo(stuID);

        boolean result = studentService.addStudent(stu); // StudentServer.addStudent method will return a boolean result.
        if (result) {
            System.out.println("Student is added");
        } else {
            System.out.println("Student is not added");
        }
    }

    // Finding Students
    public void findAllStudent() {
        // call studentService to get all students.
        Student[] students = studentService.FindAllStudents();
        // Check if the "save address" is null, if it is null, if it is null, no information.
        if (students == null) {
            System.out.println("The system is empty.");
            // it there is no data in the students array. return - to end the method.
            return;
        } else {
            // Check again, if the array id not full, there will be null value.
            for (int i = 0; i < students.length; i++) {
                Student stu = students[i];
                if (stu != null) {
                    System.out.println(stu.getId() + ".." + stu.getName() + ".." + stu.getAge() + ".." + stu.getBirthday());
                }
            }
        }
    }

    //delete students
    public void delStudentById() {
       /* String DelId;
        while (true) {
            System.out.println("Please enter Student ID.");
            DelId = sc.next();
            boolean exists = studentService.isExists(DelId);
            if (!exists) {
                System.out.println("The id is not exist, please try another one.");
            } else {
                break;
            }
        }
        */
        String DelId = inputStudentId();
        // if yes, pass the id to method delete students in the service.
        studentService.delStudentByID(DelId);
        System.out.println("The information of " + DelId + " is deleted.");
    }

    // optimise the code.

    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("Please enter Student ID.");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("The id is not exist, please try another one.");
            } else {
                break;
            }
        }
        return id;
    }

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
