package com.itheima.service;

import com.itheima.dao.TeacherDao;
import com.itheima.domain.Teacher;

public class TeacherService {

    private TeacherDao tDao = new TeacherDao();

    public boolean isExists(String id) {
        // get all teachers.
        Teacher[] allTeachers = tDao.findAllTeachers();
        boolean isExists = false;
        // iterate the teachers, find out if the id id used.
        for (int i = 0; i < allTeachers.length; i++) {
            Teacher teacher = allTeachers[i];
            // 这个老师的数组可能是没有装满的，如果没有装满，那么比较的时候是和NULL比较，所以要先找到不是NULL的信息进行比较。
            if (teacher != null && teacher.getId().equals(id)) {
                isExists = true;
                break;
            }
        }
        return isExists;
    }

    public boolean addStudent(Teacher newTeacherInfo) {
        return tDao.addTeacher(newTeacherInfo);
    }

    public Teacher[] findAllTeachers() {
        // 先从库管拿到老师信息。
        Teacher[] allTeachers = tDao.findAllTeachers();
        // flag 判断老师列表是否为空。！！！！ 技巧，判断其是否为空，先判断，是否不为空，只要有一个数据，即不为空
        // 就可以结束遍历了，这样代码更快一些。
        boolean flag = false;
        for (int i = 0; i < allTeachers.length; i++) {
            Teacher t = allTeachers[i];
            if (t != null) { // 找到第一个不为空的位置的时候，就可以返回flag了。
                flag = true;
            }
            break;
        }
        // 如果flag不是true，则数组为空，allTEACHERS 给 NULL.
        if (flag) {
            return allTeachers;
        } else {
            return null;
        }

    }

    public void delTeacherById(String delID) {
        tDao.delTeacherById(delID);
    }

    public void updateTeacherById(Teacher newTeacher, String updateId) {
        tDao.updateTeacherById(newTeacher, updateId);
    }
}
