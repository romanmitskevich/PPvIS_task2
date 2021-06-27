package com.company.actor;

import com.company.controller.GroupController;
import com.company.entity.Group;
import com.company.controller.SecretaryController;
import com.company.entity.Student;
import com.company.exception.StudentException;
import com.company.singleton.GroupSingleton;

import java.util.ArrayList;
import java.util.List;

public class Secretary implements SecretaryController {
    @Override
    public synchronized GroupController createGroup(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The argument is null!");
        }
        GroupController group = new Group(name);
        GroupSingleton.getInstance().addGroup(group);
        return group;
    }

    @Override
    public synchronized boolean deleteGroup(GroupController groupToDelete) {
        if (groupToDelete == null) {
            throw new IllegalArgumentException("The argument is null!");
        }
        return GroupSingleton.getInstance().deleteGroup(groupToDelete);
    }

    @Override
    public synchronized List<Student> getStudentsFromGroup(GroupController group) {
        if (group == null) {
            throw new IllegalArgumentException("The argument is null!");
        }
        List<GroupController> groupList = GroupSingleton.getInstance().getGroups();

        for (GroupController groupForGetStudents : groupList) {
            if (groupForGetStudents.equals(group)) {
                return groupForGetStudents.getStudents();
            }
            else
            {
                throw new StudentException("Group doesn't exists!");
            }
        }
        return null;
    }

    @Override
    public synchronized List<Student> getStudentsFromCourse(int course) {
        List<GroupController> groupList = GroupSingleton.getInstance().getGroupsByCourse(course);
        List<Student> result = new ArrayList<>();

        for (GroupController group : groupList) {
            result.addAll(group.getStudents());
        }
        return result;
    }

    @Override
    public synchronized void addStudentToGroup(Student student, GroupController newGroup) {
        if (student == null || newGroup == null) {
            throw new IllegalArgumentException("The argument is null!");
        }
        newGroup.addStudent(student);
    }
}