package com.company.entity;

import com.company.check.StudentCheck;
import com.company.controller.GroupController;
import com.company.exception.StudentException;

import java.util.ArrayList;
import java.util.List;

public class Group implements GroupController {
    private final List<Student> students;
    private int course;
    private String name;

    {
        students = new ArrayList<>();
    }

    public Group(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCourse() {
        return course;
    }

    public void addStudent(Student student) {
        if (!StudentCheck.isStudentInGroup(this, student)) {
            student.setStudying(true);
            students.add(student);
        } else {
            throw new StudentException("Student with the same surname is already in group!");
        }
    }

    public void removeStudent(Student student) {
        if (!students.remove(student)) {
            throw new StudentException("There is no such student!");
        }
        student.setStudying(false);
    }
}