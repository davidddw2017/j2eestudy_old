package org.cloud.ssm.service;

import java.util.List;

import org.cloud.ssm.model.Student;

public interface StudentService {
    void addStudent(Student student);

    List<Student> listStudent();

    void deleteStudent(long studentID);
}
