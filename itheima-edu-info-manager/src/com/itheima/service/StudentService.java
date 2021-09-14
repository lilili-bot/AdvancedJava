package com.itheima.service;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;

public class StudentService {
    private StudentDao sd = new StudentDao();

    public boolean addStudent(Student stu) {
        // pass the stu to Dao.
        StudentDao sd = new StudentDao();
        return sd.addStudent(stu);
    }

    public boolean isExists(String stuID) {
        // tell StudentDao to pass all the students information.
        // create a object of StudentDao, then use method findAllStudent.
        Student[] students = sd.findAllStudents();
        // first assume the ID is not exist.
        boolean exist = false;
        // iterate the student list, if there is one the same as input stuID, exist returns True.
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId().equals(stuID)) {
                exist = true;
            }
        }
        return exist;
    }

    public Student[] FindAllStudents() {
        // create a Student type list to take all students from DAO.
        Student[] students = sd.findAllStudents();
        boolean flag = false;
        // check if the students is empty.
        for (int i = 0; i < students.length; i++) {
            Student stu = students[i];
            if (stu != null) {
                flag = true;
                break;
            }

        }
        if(flag){
            return students;
        }else{
            return null;
        }
    }

    public void delStudentByID(String DelId) {
        // pass the studentID to DAO, to delete the student.
        sd.delStudent(DelId);
    }

    public void updateStudent(String updateId, Student newStudent) {
        // pass the updateID and newStudent to DAO.
        sd.updateStudent(updateId, newStudent);
    }
}
