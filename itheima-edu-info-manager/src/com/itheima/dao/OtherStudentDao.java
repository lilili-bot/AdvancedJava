package com.itheima.dao;

import com.itheima.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao implements BaseStudentDao {
    // add student information to the database. Create a new List to take the student.
    private static ArrayList<Student> StudentArr = new ArrayList<>();

    // 使用静态方法，在数据数组中初始化一些数据。
    {
        Student stu1 = new Student("01", "Tom", "34", "11-11");
        Student stu2 = new Student("02", "Jack", "32", "10-12");
        Student stu3 = new Student("03", "Tony", "24", "03-01");
        Student stu4 = new Student("04", "Jane", "35", "06-04");
        StudentArr.add(stu1);
        StudentArr.add(stu2);
        StudentArr.add(stu3);
        StudentArr.add(stu4);
    }

    @Override
    public boolean addStudent(Student stu) {
        return StudentArr.add(stu);
    }

    @Override
    public Student[] findAllStudents() {
        Student[] allStudents = new Student[StudentArr.size()];
        for (int i = 0; i < allStudents.length; i++) {
            allStudents[i] = StudentArr.get(i);
        }
        return allStudents;
    }

    @Override
    public void delStudent(String DelId) {
        int index = getIndex(DelId);
        StudentArr.remove(index);
    }

    @Override
    public int getIndex(String id) {
        // create index variable, initiate value with -1.
        int Index = -1;
        // Iterate student array, find the studentId with matched given id.
        for (int i = 0; i < StudentArr.size(); i++) {
            Student student = StudentArr.get(i);
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
        StudentArr.set(index, newStudent);

    }
}
