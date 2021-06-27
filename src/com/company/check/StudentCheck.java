package com.company.check;

import com.company.controller.GroupController;
import com.company.entity.Student;
import com.company.entity.Group;

import java.util.List;

public class StudentCheck {

    private StudentCheck(){

    }

    public static boolean isStudentInGroup(GroupController group, Student student){
        if (student == null || group == null) {
            throw new IllegalArgumentException("The argument is null!");
        }

        String studentSurname = student.getSurname();

        List<Student> students = group.getStudents();
        for (Student currentStudent : students) {
            String currentStudentSurname = currentStudent.getSurname();

            if (studentSurname.equals(currentStudentSurname)) {
                return true;
            }
        }

        return false;
    }
}
