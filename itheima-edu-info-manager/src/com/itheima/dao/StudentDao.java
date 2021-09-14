package com.itheima.dao;

import com.itheima.domain.Student;

public class StudentDao {
    // add student information to the database. Create a new List to take the student.
    private static Student[] StudentArr = new Student[5];

    public boolean addStudent(Student stu) {
        // loop the StudentArr and store stu information to the first null.
        int index = -1; // First assume that the list is full.
        for (int i = 0; i < StudentArr.length; i++) {
            Student student = StudentArr[i];
            if (student == null) {
                index = i;
                break; // !!!!! very important to break here. So that the data will be stored on the first NULL.
            }
        }
        // got index value. if index is -1, list is full.
        if (index == -1) {
            System.out.println("The database is full");
            // add student is failed.
            return false;
            // otherwise the list has room, add the student in the list.
        } else {
            StudentArr[index] = stu;
            // add student is successfully.
            return true;
        }
    }

    public Student[] findAllStudents() {
        return StudentArr;
    }

    public void delStudent(String DelId) {
        // look for the index of the given ID in the array.
        int index = getIndex(DelId);
        //System.out.println(index);
        StudentArr[index] = null;
        // del the students information according to the ID.
    }

    public int getIndex(String id) {
        // create index variable, initiate value with -1.
        int Index = -1;
        // Iterate student array, find the studentId with matched given id.
        for (int i = 0; i < StudentArr.length; i++) {
            Student student = StudentArr[i];
            // if the student[i] is not null, and the ID matches. Index is the i.
            if (student != null && student.getId().equals(id)) {
                //Index = getIndex(studentID);
                Index = i;
                // find the index, break the loop, to save computing power.
                break;
            }
        }
        return Index;
    }

    public void updateStudent(String updateId, Student newStudent) {
        // Find index of the given studentID
        int index = getIndex(updateId);
        StudentArr[index] = newStudent;

    }
}
