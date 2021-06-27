package com.company.controller;

import com.company.entity.Student;

import java.util.List;

public interface GroupController {
    void addStudent(Student student);
    void removeStudent(Student student);
    int getCourse();
    List<Student> getStudents();
}
