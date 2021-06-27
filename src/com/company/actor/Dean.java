package com.company.actor;


import com.company.controller.DeanController;
import com.company.controller.GroupController;
import com.company.entity.Student;
import com.company.exception.StudentException;
import com.company.singleton.GroupSingleton;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Dean implements DeanController {

    @Override
    public synchronized void changeIsStudentStudying(Student student, boolean isStudying){
        if (student == null) {
            throw new IllegalArgumentException("The argument is null!");
        }
        List<GroupController> listOfGroups = GroupSingleton.getInstance().getGroups();

        for (GroupController group : listOfGroups) {
            List<Student> students = group.getStudents();
            for (Student currentStudent : students) {
                if (currentStudent.equals(student)) {
                    student.setStudying(isStudying);
                }
            }
        }
    }

    @Override
    public synchronized Map<Student, GroupController> getStudentsInCity(List<GroupController> groups, String city) {
        List<GroupController> groupList = GroupSingleton.getInstance().getGroups();
        Map<Student, GroupController> result = new HashMap<>();

        for (GroupController group : groupList) {
            List<Student> students = group.getStudents();

            for (Student student : students) {
                if (student.getCity().equals(city)) {
                    result.put(student, group);
                }
            }
        }
        return result;
    }

    @Override
    public synchronized boolean moveStudentToAnotherGroup(Student student, GroupController newGroup) {
        if (student == null || newGroup==null) {
            throw new IllegalArgumentException("The argument is null!");
        }
        List<GroupController> groups = GroupSingleton.getInstance().getGroups();

        if (student.isStudying()) {
            if (removeStudentFromGroup(groups, student)) {
                addStudentToNewGroup(groups, student, newGroup);
            } else {
                throw new StudentException("Student is not found!");
            }
        }
        return true;
    }

    private void addStudentToNewGroup(List<GroupController> groups, Student student, GroupController newGroup) {
        for (GroupController group : groups) {
            if (group.equals(newGroup)) {
                group.addStudent(student);
                return;
            }
        }
    }

    private boolean removeStudentFromGroup(List<GroupController> groupOfStudentToBeDeleted, Student student) {
        for (GroupController group : groupOfStudentToBeDeleted) {
            List<Student> students = group.getStudents();

            for (Student currentStudent : students) {
                if (currentStudent.equals(student)) {
                    students.remove(currentStudent);
                    return true;
                }
            }
        }
        return false;
    }

}
