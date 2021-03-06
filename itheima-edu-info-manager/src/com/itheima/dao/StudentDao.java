package com.itheima.dao;

import com.itheima.domain.Student;

public class StudentDao implements BaseStudentDao {
    // add student information to the database. Create a new List to take the student.
    private static Student[] StudentArr = new Student[5];

    // 使用静态方法，在数据数组中初始化一些数据。
    {
        Student stu1 = new Student("01", "Tom", "34", "11-11");
        Student stu2 = new Student("02", "Jack", "32", "10-12");
        Student stu3 = new Student("03", "Tony", "24", "03-01");
        Student stu4 = new Student("04", "Jane", "35", "06-04");
        StudentArr[0] = stu1;
        StudentArr[1] = stu2;
        StudentArr[2] = stu3;
        StudentArr[3] = stu4;
    }

    @Override
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

    @Override
    public Student[] findAllStudents() {
        return StudentArr;
    }

    @Override
    public void delStudent(String DelId) {
        // look for the index of the given ID in the array.
        int index = getIndex(DelId);
        //System.out.println(index);
        StudentArr[index] = null;
        // del the students information according to the ID.
    }

    @Override
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

    @Override
    public void updateStudent(String updateId, Student newStudent) {
        // Find index of the given studentID
        int index = getIndex(updateId);
        StudentArr[index] = newStudent;
    }
}
