package com.company.controller;

import com.company.entity.Student;
import com.company.controller.GroupController;
import java.util.List;
import java.util.Map;

public interface ProfessorController {
    List<Student> getStudentsFromGroup(GroupController group);
    Map<Student, GroupController> getStudentsBySurname(String surname);
}
