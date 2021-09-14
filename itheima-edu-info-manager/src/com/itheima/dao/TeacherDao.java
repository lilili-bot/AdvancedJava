package com.itheima.dao;

import com.itheima.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teachersArr = new Teacher[5];

    public boolean addTeacher(Teacher newTeacherInfo) {
        // 先遍历老师的数组，找到第一个在该数组可用的位置，拿到该位置的索引号码。
        int Index = -1;
        for (int i = 0; i < teachersArr.length; i++) {
            Teacher teacher = teachersArr[i];
            if (teacher == null) {
                Index = i;
                break;
            }
        }
        // 拿到索引之后，先看索引是不是-1？
        if (Index == -1) { // index是-1， 教师的数组满了，返回false
            System.out.println("the list is full.");
            return false;
        } else { // index不是-1，数组还有位置，把新的老师信息添加到数组该索引位置，返回true。
            teachersArr[Index] = newTeacherInfo;
            return true;
        }
    }

    public Teacher[] findAllTeachers() {
        return teachersArr;
    }

    public void delTeacherById(String delID) {
        // get Index of the teacher in the list.
        int index = getIndex(delID);
        teachersArr[index] = null;
    }

    public int getIndex(String id) {
        // iterate the list and get the index.
        int index = -1;
        for (int i = 0; i < teachersArr.length; i++) {
            Teacher teacher = teachersArr[i];
            if(teacher!=null && teacher.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateTeacherById(Teacher newTeacher, String updateId) {
        // get index of the given id.
        int index = getIndex(updateId);
        teachersArr[index] = newTeacher;
    }
}
