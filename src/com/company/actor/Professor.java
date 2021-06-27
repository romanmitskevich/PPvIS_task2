package com.company.actor;

import com.company.controller.GroupController;
import com.company.entity.Group;
import com.company.controller.ProfessorController;
import com.company.entity.Student;
import com.company.exception.StudentException;
import com.company.singleton.GroupSingleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Professor implements ProfessorController{

    @Override
    public synchronized List<Student> getStudentsFromGroup(GroupController group) {
        if (group == null) {
            throw new IllegalArgumentException("The argument is null!");
        }

        List<GroupController> groupList = GroupSingleton.getInstance().getGroups();

        for (GroupController currentGroup : groupList) {
            if (currentGroup.equals(group)) {
                return currentGroup.getStudents();
            }
            else
            {
                throw new StudentException("Group doesn't exists!");
            }
        }
        return null;
    }

    @Override
    public synchronized Map<Student, GroupController> getStudentsBySurname(String surname) {
        Map<Student, GroupController> result = new HashMap<>();
        List<GroupController> listOfGroups = GroupSingleton.getInstance().getGroups();

        for (GroupController group : listOfGroups) {
            List<Student> students = group.getStudents();
            for (Student student : students) {
                if (student.getSurname().equals(surname)) {
                    result.put(student, group);
                }
            }
        }
        return result;
    }
}
