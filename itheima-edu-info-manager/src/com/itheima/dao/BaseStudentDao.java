package com.itheima.dao;

import com.itheima.domain.Student;

public interface BaseStudentDao {
    // add student information to the database. Create a new List to take the student.


    public abstract boolean addStudent(Student stu);

    public abstract Student[] findAllStudents();

    public abstract void delStudent(String DelId);

    public abstract int getIndex(String id);

    public abstract void updateStudent(String updateId, Student newStudent);
}
