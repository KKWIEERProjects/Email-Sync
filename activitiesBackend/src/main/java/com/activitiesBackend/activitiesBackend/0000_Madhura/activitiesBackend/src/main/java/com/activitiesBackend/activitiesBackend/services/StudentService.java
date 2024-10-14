package com.activitiesBackend.activitiesBackend.services;

import java.util.List;

import com.activitiesBackend.activitiesBackend.Entities.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String id);
    Student createStudent(Student student);
    Student updateStudent(String id, Student student);
    void deleteStudent(String id);
}
