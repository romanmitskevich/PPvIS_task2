package com.company.controller;

import com.company.entity.Student;
import com.company.controller.GroupController;

import java.util.List;
import java.util.Map;

public interface DeanController {
    void changeIsStudentStudying(Student student, boolean isStudying);
    Map<Student, GroupController> getStudentsInCity(List<GroupController> groups, String city);
    boolean moveStudentToAnotherGroup(Student student, GroupController newGroup);
}
