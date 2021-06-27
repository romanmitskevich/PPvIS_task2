package com.company.controller;

import com.company.controller.GroupController;
import com.company.entity.Student;

import java.util.List;

public interface SecretaryController {
    GroupController createGroup(String name);
    boolean deleteGroup(GroupController groupToDelete);
    List<Student> getStudentsFromGroup(GroupController group);
    List<Student> getStudentsFromCourse(int course);
    void addStudentToGroup(Student student, GroupController newGroup);
}
